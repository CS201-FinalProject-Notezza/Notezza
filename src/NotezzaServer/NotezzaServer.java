package NotezzaServer;

import objects.*;
import db.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class NotezzaServer {
    
    private Vector<ServerThread> serverThreads;
    private DataContainer data;
    
    private NotezzaServer(int port) {
        try {
            // Bind to port
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Notezza server has started. Bind to port " + port);
            serverThreads = new Vector<>();
            parseDatabase();
            
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
        
        NotezzaServer server = new NotezzaServer();
    }
    
    
    public void parseDatabase() {
        
    }
    
    void processCommand(Command command, ServerThread thread) {
        CommandType type = command.getType();
        switch (type) {
            case INITIALIZATION:
                
                break;
            case LOGIN:
                
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
        }
    }
    
    
    
}
