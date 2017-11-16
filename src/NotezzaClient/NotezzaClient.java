package NotezzaClient;

import java.io.IOException;
import java.net.Socket;

public class NotezzaClient extends Thread {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    NotezzaClient(String hostname, int port) {
        try {
            System.out.println("Trying to establis connection to Notezza server at " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to Notezza server at " + hostname + ":" + port);
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            this.start();
//            Wait for figuring out what to do here
//            while(true) {
//                
//            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(true) {
            Command cmd = (Command) ois.readObject();
            Object obj = cmd.getObject();
            
        }

    }

    public static void main(String[] args) {
        //NotezzaClient = new NotezzaClient(host,6879);
    }
}
