package NotezzaClient;

import java.io.IOException;
import java.net.Socket;

public class NotezzaClient extends Thread {

    NotezzaClient(String hostname, int port) {
        try {
            System.out.println("Trying to connect to " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to " + hostname + ":" + port);


            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

    }

    public static void main(String[] args) {
        //NotezzaClient = new NotezzaClient(host,6879);
    }
}
