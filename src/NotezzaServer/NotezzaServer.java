package NotezzaServer;

import db.DatabaseManager;
import objects.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import static NotezzaServer.CommandType.*;


public class NotezzaServer {
    
    private Vector<ServerThread> serverThreads;
    private DatabaseManager dm;
    private ServerSocket ss;
    
    private NotezzaServer(int port) {
        try {
            // Bind to port
            ss = new ServerSocket(port);
            System.out.println("Notezza server has started. Bind to port " + port);
            serverThreads = new Vector<ServerThread>();
            dm = new DatabaseManager();

            System.out.println("Printing database...");
            System.out.println(dm.toString());

            
        } catch (IOException ioe) {
            System.out.println("IOException in server constructor: " + ioe.getMessage());
            System.out.println("Failed to start server.");
        }
    }
    
    public void runServer() {
    	while (true) {
    		try {
	            Socket socket = ss.accept(); // blocking
	            System.out.println("Connection from: " + socket.getInetAddress());
	            ServerThread st = new ServerThread(socket, this);
	            serverThreads.add(st);
    		} catch (IOException ioe) {
    			System.out.println("IOException in run server: " + ioe.getMessage());
    		}
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Staring the Notezza server");
        Scanner scan = new Scanner(System.in);
        int port;
        while(true) {
            System.out.println("Port to bind the server to: ");
            try {
                String line = scan.nextLine();
                port = Integer.parseInt(line);
                // The port number has to fall in the valid range 1024 - 65536
                if(port < 1024 || port > 65536) {
                    System.out.println("Invalid port number.");
                }
                else {
                    break;
                }
            } catch(NumberFormatException nme) { // Check the validity of the user's input
                System.out.println("Invalid port number.");
            }
        }
        
        NotezzaServer server = new NotezzaServer(port);
        server.runServer();
    }
    
    void removeServerThread(ServerThread st) {
    	if (serverThreads.contains(st)) {
    		serverThreads.remove(serverThreads.indexOf(st));
    	}
    }
    
    void processCommand(Command command, ServerThread thread) {
        CommandType type = command.getType();
        Object obj = command.getObject();
        switch (type) {
            case INITIALIZATION_STUDENT:
                System.out.println("Send out initialization (Student) ...");
                String userName = (String) obj;
                CourseList courseList = new CourseList(dm.findUserCourses(userName));
                thread.sendCommand(new Command(INITIALIZATION_STUDENT,courseList));
                break;
            case INITIALIZATION_INSTRUCTOR:
                System.out.println("Send out initialization (Instructor) ...");
                String instructorName = (String) obj;
                List<Course> courses = dm.findInstructorCourses(instructorName);
                CourseList courseListForInstructor = new CourseList(dm.findUserCourses(instructorName));
                thread.sendCommand(new Command(INITIALIZATION_INSTRUCTOR,courseListForInstructor));
                break;
            case LOGIN:
                System.out.println("Received login request...");
                LoginCredential loginCredential = (LoginCredential) obj;
                String username = loginCredential.getUsername();
                String password = loginCredential.getPassword();
                System.out.println("Username :" + username);
                System.out.println("Unhashed password: " + password);
                int hashedPassword = passwordHasher(password);
                System.out.println("Hashed password: " + hashedPassword);
                Map<String,User> allUsers = dm.getAllUsers();
                User tempUser = allUsers.get(username);
                if (tempUser != null && tempUser.getPassword() == hashedPassword) {
                    System.out.println("LOGIN SUCCESS");
                    Command loginSuccessful = new Command(LOGIN,tempUser);
                    thread.sendCommand(loginSuccessful);
                } else {
                    System.out.println("LOGIN FAIL");
                    Command loginFailed = new Command(LOGIN_FAIL, null);
                    thread.sendCommand(loginFailed);
                }
                break;
            case REGISTER:
                System.out.println("Received request for registration...");
                UserCredential userCredential = (UserCredential) obj;
                //User(String fname, String lname, String username, String email, long password, boolean isInstructor, boolean isVisible)
                User user = new User(userCredential.getFname(),userCredential.getLname(),userCredential.getUsername(),
                        userCredential.getEmail(),passwordHasher(userCredential.getPassword()),
                        userCredential.isInstructor(),userCredential.isVisible());
                // Add to database
                dm.addUser(user);
                thread.sendCommand(new Command(REGISTER_DONE,user));
                break;
            case CREATE_CLASS:
                System.out.println("Received request to create class...");
                CreateClassInfo classInfo = (CreateClassInfo) obj;
                String courseName = classInfo.getCourseName();
                String[] emails = classInfo.getEmails();
                User instructor = classInfo.getInstructor();
                Vector<User> students = checkEmails(emails);
                Course course = new Course(courseName,instructor,students);
                dm.addCourse(course);
                broadcast(new Command(UPDATE_CLASS,course));
                break;
            case CREATE_PRESENTATION:
                System.out.println("Received request to create new presentation...");
                PresentationANDCourse pc = (PresentationANDCourse) obj;
                Presentation presentation = pc.getPresentation();
                Course courseForPresentation = pc.getCourse();
                dm.addPresentation(presentation,courseForPresentation);
                broadcast(new Command(UPDATE_PRESENTATION, presentation));
                break;
            case ADD_COMMENT:
                System.out.println("Received request to add comment...");
                CourseNoteComment cnc = (CourseNoteComment) obj;
                Comment comment = cnc.getComment();
                // Add to the database
                dm.addComment(comment);
                //Broadcast the comment
                broadcast(new Command(UPDATE_COMMENT, cnc));
                break;
            case ADD_NOTE:
                System.out.println("Received request to add note...");
                CourseANDNote cn = (CourseANDNote) obj;
                Course courseForNote = cn.getCourse();
                Note note = cn.getNote();
                dm.addNote(note,courseForNote);
                broadcast(new Command(UPDATE_NOTE,cn));
                break;
            case SEND_CHAT_MESSAGE:
                System.out.println("Received a chat message...");
                ChatMessage cm = (ChatMessage) obj;
                broadcast(new Command(UPDATE_CHAT, cm));
                break;
            case ADD_LIKE:
                System.out.println("Received a like...");
                AddingLike addLike = (AddingLike) obj;
                User likedUser = addLike.getUser();
                Note likedNote = addLike.getNote();
                dm.addNoteVote(likedNote,likedUser,true);
                broadcast(new Command(UPDATE_NOTE,likedNote));
                break;
            case ADD_DISLIKE:
                System.out.println("Received a dislike...");
                AddingDislike addDislike = (AddingDislike) obj;
                User disLikedUser = addDislike.getUser();
                Note disLikedNote = addDislike.getNote();
                dm.addNoteVote(disLikedNote,disLikedUser,false);
                broadcast(new Command(UPDATE_NOTE,disLikedNote));
                break;
            case SEND_QUIZ:
                System.out.println("Received a request to display quiz...");
                Quiz quiz = (Quiz) obj;
                broadcast(new Command(UPDATE_QUIZ,quiz));
        }
    }

    private Vector<User> checkEmails(String[] emails) {
        System.out.println("Checking emails for creating classes...");
        Vector<User> students = new Vector<>();
        Map<String,User> userMap = dm.getAllUsers();
        Map<String,User> emailToUser = new HashMap<>();
        for (User user : userMap.values()) {
            emailToUser.put(user.getEmail(),user);
        }
        for (String email : emails) {
            if (emailToUser.get(email) != null) {
                students.add(emailToUser.get(email));
            }
        }
        return students;
    }

    private int passwordHasher(String password){
        long passInt = 0;
        int n = password.length();
        int [] passArr = new int[4];
        int encryptedCode;

        for (int idx = 0; idx < n; idx ++) {
            passInt += (long)(Math.pow(128, n-1-idx))* Character.getNumericValue(password.charAt(idx));
        }
        
        for (int i = 3; i >=0; i--){
            passArr[i] = (int) (passInt % 65521);
            passInt = passInt / 65521;
        }
        
        encryptedCode = (45912*passArr[0] + 35511*passArr[1]
                         + 65169*passArr[2] + 4625*passArr[3]) % 65521;
        
        return encryptedCode;
    }

    private void broadcast(Command command) {
        for (ServerThread thread : serverThreads) {
            thread.sendCommand(command);
        }
    }
    
    
}
