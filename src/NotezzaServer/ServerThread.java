package NotezzaServer;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private NotezzaServer server;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    ServerThread(Socket socket, NotezzaServer server) {
        try {
            this.server = server;

            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            this.start();
        } catch (IOException ioe) {
            System.out.println("ioe in Server.ServerThread constructor: " + ioe.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Command command = (Command) ois.readObject();
                server.processCommand(command, this);

            }
        } catch (EOFException e) {
            System.out.println("A client quits.");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    void sendCommand(Command command) {
        try {
            oos.writeObject(command);
            oos.flush();
        } catch (IOException ioe) {
            System.out.println("ioe: " + ioe.getMessage());
        }
    }
}
