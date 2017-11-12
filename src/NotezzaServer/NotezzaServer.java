package NotezzaServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class NotezzaServer {

    private Vector<ServerThread> serverThreads;

    private NotezzaServer(int port) {
        try {
            // Binding to port
            ServerSocket ss = new ServerSocket(port);
            // Bound to port
            System.out.println("Successfully started the Black Jack server on port " + port);
            serverThreads = new Vector<>();
            while (true) {
                Socket socket = ss.accept(); // blocking
                System.out.println("Connection from: " + socket.getInetAddress());
                ServerThread st = new ServerThread(socket, this);
                serverThreads.add(st);
            }
        } catch (IOException ioe) {
            System.out.println("IOException in server constructor: " + ioe.getMessage());
        }
    }

    void processCommand(Command command, ServerThread thread) {

    }

    public static void main(String[] args) {
        NotezzaServer server = new NotezzaServer(6789);
    }
}
