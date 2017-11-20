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
import GUI.InstructorWindow;
import GUI.UserPresentation;
import GUI.UserWindow;
import NewGUI.Login;
import NewGUI.MainWin;
import NewGUI.MainWinInstr;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.ChatMessage;
import objects.CourseList;
import objects.Quiz;
import objects.User;

public class NotezzaClient extends Thread {
    private User user;
    private CourseList courseList;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public User getUser() { return user; }

    // Windows
    //private LoginScreen loginWindow;
    private UserWindow userWindow;
    private InstructorWindow instructorWindow;

    // New GUI
    private JFrame loginWindow;
    private JFrame mainWindow;
    private UserPresentation userPresentationWindow = null;
    private InstructorPresentation instrPresentationWindow = null;

    NotezzaClient(String hostname, int port) {

        try {
            System.out.println("Trying to connect to " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to " + hostname + ":" + port);
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            /* Below is the Old GUI
            LoginScreen loginScreen = new LoginScreen(this);
            loginScreen.frame.setVisible(true);
            */
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
            System.out.println("Command sent: " + cm.getObject().toString());
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
                // TODO Need to display login failure message on login windW\; Wait for GUI to finish
                break;
            case REGISTER_DONE:
                user = (User) obj;
                // A new user should not see anything, just pop up a window
                if (!user.isInstructor()) {
                    userWindow = new UserWindow(this, courseList);
                    userWindow.setVisible(true);
                } else {
                    instructorWindow = new InstructorWindow(this, courseList, null);
                    instructorWindow.setVisible(true);
                }
                break;
            case INITIALIZATION_STUDENT:
                courseList = (CourseList) obj;
                System.out.println("WE GOT EVERYTHING! POPPING UP THE STUDENT WINDOW!");
                loginWindow.setVisible(false);
                //pop up userWindow OLD GUI
                /*
                userWindow = new UserWindow(this, courseList);
                userWindow.setVisible(true);
                */
                // TODO UPDATE TO NEW GUI WHEN READY
                // new GUI
                mainWindow = new MainWin(this,courseList);
                mainWindow.setVisible(true);
                break;
            case INITIALIZATION_INSTRUCTOR:
                courseList = (CourseList) obj;
                System.out.println("WE GOT EVERYTHING! POPPING UP THE INSTRUCTOR WINDOW!");
                loginWindow.setVisible(false);
                // pop up instructor window OLD GUI
                /*
                instructorWindow = new InstructorWindow(this, courseList,userSet);
                instructorWindow.setVisible(true);
                */
                // TODO UPDATE TO NEW GUI WHEN READY
                mainWindow = new MainWinInstr(this,courseList);
                mainWindow.setVisible(true);
                break;
            case UPDATE_COMMENT:
                // TODO update COMMENT
                System.out.println("Updating comment");
                break;
            case UPDATE_NOTE:
                // TODO Update NOTE
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
        NotezzaClient client = new NotezzaClient("localhost",1234);
    }
}
