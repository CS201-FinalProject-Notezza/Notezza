package NotezzaClient;

import static NotezzaServer.CommandType.INITIALIZATION_INSTRUCTOR;
import static NotezzaServer.CommandType.INITIALIZATION_STUDENT;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;

import GUI.InstructorPresentation;
import GUI.LoginError;
import GUI.UserPresentation;
import NewGUI.Login;
import NewGUI.MainWin;
import NewGUI.MainWinInstr;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.*;

public class NotezzaClient extends Thread {
    private User user;
    private CourseList courseList;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public User getUser() { return user; }

    // New GUI
    private JFrame loginWindow;
    private MainWin mainWin;
    private MainWinInstr mainWinInstr;
    private UserPresentation userPresentationWindow = null;
    private InstructorPresentation instrPresentationWindow = null;

    NotezzaClient(String hostname, int port) {

        try {
            System.out.println("Trying to connect to " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to " + hostname + ":" + port);
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            popUpLogin();
            System.out.println("Window opened");
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // Keep listening from server
        try {
            while (true) {
                Command cm = (Command) ois.readObject();
                processCommand(cm);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setInstructorPresentationWindow(InstructorPresentation pw) {
    	this.instrPresentationWindow = pw;
    }
    
    public void setUserPresentationWindow(UserPresentation pw) {
    	this.userPresentationWindow = pw;
    }

    public void sendCommand(Command cm) {
        try {
            oos.writeObject(cm);
            oos.flush();
            if (cm.getObject() != null) {
            	System.out.println("Command sent: " + cm.getObject().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processCommand(Command cm) {
        CommandType type = cm.getType();
        Object obj = cm.getObject();

        switch (type) {
            case LOGIN:
                user = (User) obj;
                if(user.isInstructor()){
                    sendCommand(new Command(INITIALIZATION_INSTRUCTOR, user.getUsername()));
                } else {
                    sendCommand(new Command(INITIALIZATION_STUDENT, user.getUsername()));
                }
                break;
            case LOGIN_FAIL:
                LoginError le = new LoginError();
                le.setVisible(true);
                break;
            case REGISTER_DONE:
                user = (User) obj;
                // A new user should not see anything, just pop up a window
                if (!user.isInstructor()) {
                    mainWin = new MainWin(this, courseList);
                    mainWin.setVisible(true);
                } else {
                    mainWinInstr = new MainWinInstr(this, courseList);
                    mainWinInstr.setVisible(true);
                }
                break;
            case INITIALIZATION_STUDENT:
                courseList = (CourseList) obj;
                System.out.println("WE GOT EVERYTHING! POPPING UP THE STUDENT WINDOW!");
                loginWindow.setVisible(false);
              
                // new GUI
                mainWin = new MainWin(this,courseList);
                mainWin.setVisible(true);
                break;
            case INITIALIZATION_INSTRUCTOR:
                courseList = (CourseList) obj;
                System.out.println("WE GOT EVERYTHING! POPPING UP THE INSTRUCTOR WINDOW!");
                loginWindow.setVisible(false);
                
                mainWinInstr = new MainWinInstr(this,courseList);
                mainWinInstr.setVisible(true);
                break;
            case UPDATE_COMMENT:
                System.out.println("Updating comment");
                CourseNoteComment cnc = (CourseNoteComment) obj;
                Course course = cnc.getCourse();
                Comment comment = cnc.getComment();
                Note note = cnc.getNote();
                if (mainWin != null) {
                    mainWin.addComment(course,note,comment);
                } else if (mainWinInstr != null) {
                    //TODO uncomment
                    mainWinInstr.addComment(course,note,comment);
                }
                break;
            case UPDATE_NOTE:
                // TODO update note
                System.out.println("Updating note");
                CourseANDNote cn = (CourseANDNote) obj;
                if (mainWin != null) {
                    mainWin.addNote(cn.getCourse(), cn.getNote());
                } else if (mainWinInstr != null) {
                    // TODO uncomment
                    mainWinInstr.addNote(cn.getCourse(),cn.getNote());
                }
                break;
            case UPDATE_CLASS:
                // TODO UPDATE CLASS
                break;
            case UPDATE_PRESENTATION:
                // TODO UPDATE PRESENTATION
                break;
            case UPDATE_CHAT:
            	ChatMessage message = (ChatMessage) obj;
            	if (user.isInstructor()) {
                	instrPresentationWindow.receiveChatMessage(message);
            	} else {
                	userPresentationWindow.receiveChatMessage(message);
            	}
                break;
            case UPDATE_QUIZ:
            	Quiz quiz = (Quiz) obj;
            	if (!user.isInstructor()) {
            		userPresentationWindow.updateQuiz(quiz);
            	}
            	break;
            case UPDATE_LIKE:
                AddingLike addLike = (AddingLike) obj;
                if (user.isInstructor()) {
                    // TODO uncomment
                    mainWinInstr.addLike(addLike);
                } else {
                    // TODO uncomment
                    //userPresentationWindow.addLike(addLike);
                }
                break;
            case UPDATE_DISLIKE:
                AddingDislike addDislike = (AddingDislike) obj;
                if (user.isInstructor()) {
                    // TODO uncomment
                   mainWinInstr.addDisLike(addDislike);
                } else {
                    // TODO uncomment
                   // userPresentationWindow.addDislike(addDislike);
                }
                break;
            default:
                break;
        }
    }

    private void popUpLogin() {
        loginWindow = new JFrame();
        Login lg = new Login(this);
        loginWindow.setLayout(new BorderLayout());
        loginWindow.add(lg, BorderLayout.CENTER);
        loginWindow.setSize(630, 400);
        loginWindow.setLocationRelativeTo(null);
        loginWindow.setResizable(false);
        loginWindow.setVisible(true);
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        NotezzaClient client = new NotezzaClient("localhost",8080);
    }
}
