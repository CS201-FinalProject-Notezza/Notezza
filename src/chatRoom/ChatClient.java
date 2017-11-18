package chatRoom;

import objects.ChatMessage;

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

            objectInputStream = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
            this.start();
            Scanner scan = new Scanner(System.in);
            while (true) {
                String line = scan.nextLine();
                ChatMessage cm = new ChatMessage("Username2", line);
                objectOutputStream.writeObject(cm);
                objectOutputStream.flush();
            }

        } catch (IOException ioe) {
            System.out.println("ioe in ChatClient constructor: " + ioe.getMessage());
        }
    }

    public void run(){
        try {
            while (true) {
                ChatMessage cm = (ChatMessage) objectInputStream.readObject();
                if (cm != null) {
                    System.out.println(cm.getUsername() + ":" + cm.getMessage());
                }
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
