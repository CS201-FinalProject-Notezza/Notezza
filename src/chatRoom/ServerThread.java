package chatRoom;

import objects.ChatMessage;

import java.io.*;
import java.net.Socket;

class ServerThread extends Thread{

    private ChatRoom cr;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    ServerThread(Socket s, ChatRoom cr) {
        try {
            this.cr = cr;
            objectOutputStream = new ObjectOutputStream(s.getOutputStream());
            objectInputStream = new ObjectInputStream(s.getInputStream());
            this.start();
        } catch (IOException ioe) {
            System.out.println("ioe in ServerThread constructor: " + ioe.getMessage());
        }
    }

    public void run() {
        try {
            while (true) {
                ChatMessage cm = (ChatMessage) objectInputStream.readObject();
                if (cm == null) {
                    continue;
                }
                cr.broadcast(cm, this);
            }
        } catch (ClassNotFoundException cnfe){
            System.out.println("cnfe:" + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ioe in ServerThread.run(): " + ioe.getMessage());
        }
    }

    void sendMessage(ChatMessage message) {
        try {
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException ioe) {
            System.out.println("ioe: " + ioe.getMessage());
        }
    }
}
