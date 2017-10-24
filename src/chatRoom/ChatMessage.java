package chatRoom;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    public static final long serialVersionUID = 1;
    private String username;
    private String message;

    ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }

    String getUsername() {
        return this.username;
    }

    String getMessage() {
        return this.message;
    }


}
