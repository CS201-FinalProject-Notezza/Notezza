package chatRoom;

import objects.ChatMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class ChatRoom {

    private List<ServerThread> serverThreads;

    private ChatRoom(int port) {
        try {
            System.out.println("Binding to port" + port);
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Bound to port " + port);
            serverThreads = new Vector<>();
            while (true) {
                Socket s = ss.accept(); // blocking
                System.out.println("Connection from: " + s.getInetAddress());
                ServerThread st = new ServerThread(s, this);
                serverThreads.add(st);
            }
        } catch (IOException ioe) {
            System.out.println("ioe in ChatRoom constructor: " + ioe.getMessage());
        }
    }

    void broadcast(ChatMessage cm, ServerThread st) {
        if (cm == null) {
            return;
        }
        System.out.println(cm.getUsername() + ":" + cm.getMessage());
        for (Iterator<ServerThread> iterator = serverThreads.iterator(); iterator.hasNext();) {
            ServerThread thread = iterator.next();
            if (thread.isAlive()) {
                if (st != thread) {
                    thread.sendMessage(cm);
                }
            } else {
                iterator.remove();
            }

        }
    }

    public static void main(String[] args) {
        ChatRoom cr = new ChatRoom(6789);
    }
}
