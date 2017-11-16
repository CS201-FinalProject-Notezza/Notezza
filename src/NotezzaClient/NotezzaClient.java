package NotezzaClient;

import GUI.LoginScreen;
import GUI.UserWindow;
import NotezzaServer.Command;
import NotezzaServer.CommandType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NotezzaClient extends Thread {

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
                String info = (String) obj;
                if (info.equals("SUCCESS")) {
                    // pop up userWindow
                } else if (info.equals("SUCCESSI")) {
                    // pop up instructor window
                }
                break;
        }
    }

    public static void main(String[] args) {
        //NotezzaClient client = new NotezzaClient("localhost",6879);
    }
}
