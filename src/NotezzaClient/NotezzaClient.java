package NotezzaClient;

import GUI.*;
import objects.*;
import NotezzaServer.Command;
import NotezzaServer.CommandType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static NotezzaServer.CommandType.*;

public class NotezzaClient extends Thread {
    private User user;
    private CourseList courseList;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    NotezzaClient(String hostname, int port) {

        try {
            System.out.println("Trying to connect to " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to " + hostname + ":" + port);
            LoginScreen loginScreen = new LoginScreen(this);
            loginScreen.frame.setVisible(true);

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
                // Need to displaye login failure message on login window
                // Wait for GUI to finish
                break;
            case INITIALIZATION_STUDENT:
                courseList = (CourseList)obj;
                // pop up userWindow
                UserWindow userwindow = new UserWindow(this);
                userwindow.setVisible(true);
                break
            case INITIALIZATION_INSTRUCTOR:
                // pop up instructor window
                InstructorWindow instructorWindow = new InstructorWindow(this);
                instructorWindow.setVisible(true);
                break;
                
                
                
            default:
                break;
        }
    }

    public static void main(String[] args) {
        //NotezzaClient client = new NotezzaClient("localhost",6879);
    }
}
