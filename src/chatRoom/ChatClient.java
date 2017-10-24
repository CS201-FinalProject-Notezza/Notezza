package chatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {

    private ObjectInputStream objectInputStream;

    private ChatClient(String hostname, int port) {
        try {
            System.out.println("Trying to connect to " + hostname + ":" + port);
            Socket s = new Socket(hostname, port);
            System.out.println("Connected to " + hostname + ":" + port);

            //br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //PrintWriter pw = new PrintWriter(s.getOutputStream());

            objectInputStream = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
            this.start();
            Scanner scan = new Scanner(System.in);
            while (true) {
                String line = scan.nextLine();
                ChatMessage cm = new ChatMessage("Chairman", line);
                objectOutputStream.writeObject(cm);
                objectOutputStream.flush();
                //pw.println("Chairman FROG:" + line);
                //pw.flush();
            }

        } catch (IOException ioe) {
            System.out.println("ioe in ChatClient constructor: " + ioe.getMessage());
        }
    }

    public void run(){
        try {
            while (true) {
                //String line = br.readLine();
                //System.out.println(line);
                ChatMessage cm = (ChatMessage) objectInputStream.readObject();
                System.out.println(cm.getUsername() + ":" + cm.getMessage());
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("cnfe: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ioe in ChatClient.run(): " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        ChatClient cc = new ChatClient("localhost", 6789);
    }
}
