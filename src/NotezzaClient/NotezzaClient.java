package NotezzaClient;

import GUI.*;
import NewGUI.Login;
import objects.*;
import NotezzaServer.Command;
import NotezzaServer.CommandType;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

import static NotezzaServer.CommandType.*;

public class NotezzaClient extends Thread {
    private User user;
    private CourseList courseList;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private InstructorIntialization instInit = null;

    public User getUser() { return user; }

    // Windows
    //private LoginScreen loginWindow;
    private UserWindow userWindow;
    private InstructorWindow instructorWindow;

    // New GUI
    private JFrame loginWindow;
    

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
                // Need to display login failure message on login window
                // Wait for GUI to finish
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
                System.out.println("WE GOT EVERYTHING! POPING UP THE WINDOW!");
                // pop up userWindow
                userWindow = new UserWindow(this, courseList);
                userWindow.setVisible(true);
                break;
            case INITIALIZATION_INSTRUCTOR:
                instInit = (InstructorIntialization) obj;
                courseList = new CourseList(instInit.getCourse());
                Set<User> userSet = instInit.getAllUsers();
                // pop up instructor window
                instructorWindow = new InstructorWindow(this, courseList,userSet);
                instructorWindow.setVisible(true);
                break;
            case UPDATE_COMMENT:
                // Update the comment
                break;
            case UPDATE_NOTE:
                // Update the note
                break;
            default:
                break;
        }
    }

    public void popUpLogin() {
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
