package NotezzaClient;

import objects.*;
import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NotezzaClient extends Thread {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    NotezzaClient(String hostname, int port) {
        try {
            System.out.println("Trying to connect to " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to " + hostname + ":" + port);
            while (true) {
                
            }
            
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        while (true) {
            Command cmd = (Command) ois.readObject();
            Object obj = cmd.getObject();
            
        }
        
    }
    
    public static void main(String[] args) {
        //NotezzaClient = new NotezzaClient(host,6879);
    }
}