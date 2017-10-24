package chatRoom;

import java.io.*;
import java.net.Socket;

class ServerThread extends Thread{

    //private PrintWriter pw;
    //private BufferedReader br;
    private ChatRoom cr;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    ServerThread(Socket s, ChatRoom cr) {
        try {
            this.cr = cr;
            //pw = new PrintWriter(s.getOutputStream());
            //br = new BufferedReader(new InputStreamReader(s.getInputStream()));
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
                //String line = br.readLine();
                //cr.broadcast(line, this);
                ChatMessage cm = (ChatMessage) objectInputStream.readObject();
                cr.broadcast(cm,this);
            }
        } catch (ClassNotFoundException cnfe){
            System.out.println("cnfe:" + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ioe in ServerThread.run(): " + ioe.getMessage());
        }
    }

    void sendMessage(ChatMessage message) {
        //pw.println(message);
        //pw.flush();
        try {
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException ioe) {
            System.out.println("ioe: " + ioe.getMessage());
        }
    }
}
