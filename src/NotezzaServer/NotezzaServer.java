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
    private DataContainer data;
    private DatabaseManager dm;
    
    private NotezzaServer(int port) {
        try {
            // Bind to port
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Notezza server has started. Bind to port " + port);
            serverThreads = new Vector<>();
            dm = new DatabaseManager();
            data = dm.getDataContainer();

            System.out.println("Printing database...");
            System.out.println(data.toString());

            while (true) {
                Socket socket = ss.accept(); // blocking
                System.out.println("Connection from: " + socket.getInetAddress());
                ServerThread st = new ServerThread(socket, this);
                serverThreads.add(st);
            }
        } catch (IOException ioe) {
            System.out.println("IOException in server constructor: " + ioe.getMessage());
            System.out.println("Failed to start server.");
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
    }
    
    void processCommand(Command command, ServerThread thread) {
        CommandType type = command.getType();
        Object obj = command.getObject();
        switch (type) {
            case INITIALIZATION_STUDENT:
                String userName = (String) obj;
                CourseList courseList = new CourseList(data.findUserCourses(userName));
                thread.sendCommand(new Command(INITIALIZATION_STUDENT,courseList));
                break;
            case INITIALIZATION_INSTRUCTOR:
                String instructorName = (String) obj;
                CourseList instructorCourseList = new CourseList(data.findInstructorCourses(instructorName));
                thread.sendCommand(new Command(INITIALIZATION_STUDENT,instructorCourseList));
                break;
            case LOGIN:
                System.out.println("Received login request...");
                LoginCredential loginCredential = (LoginCredential) obj;
                String username = loginCredential.getUsername();
                String password = loginCredential.getPassword();
                int hashedPassword = passwordHasher(password);

                Map<String,User> allUsers = data.getAllUsers();
                User tempUser = allUsers.get(username);
                if (tempUser != null && tempUser.getPassword() == hashedPassword) {
                    Command loginSuccessful = new Command(LOGIN,tempUser);
                    thread.sendCommand(loginSuccessful);
                } else {
                    Command loginFailed = new Command(LOGIN_FAIL, null);
                    thread.sendCommand(loginFailed);
                }
                break;
            case REGISTER:
                
                break;
            case CREATE_CLASS:
                
                break;
            case VIEW_PRESENTATION:
                
                break;
            case CREATE_PRESENTATION:
                
                break;
            case VIEW_CLASS_INFORMATION:
                
                break;

            case ADD_COMMENT:
                Comment comment = (Comment) obj;
                // Add to the database
                dm.addComment(comment);
                //Broadcast the comment
                Command updateComment = new Command(UPDATE_COMMENT, comment);
                broadcast(updateComment);
                break;
        }
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
