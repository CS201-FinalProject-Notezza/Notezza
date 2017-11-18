package objects;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    public static final long serialVersionUID = 134;
    private String username;
    private String message;
    private Course course;

    public ChatMessage(String username, String message, Course course) {
        this.username = username;
        this.message = message;
        this.course = course;
    }

    public String getUsername() {
        return this.username;
    }

    public String getMessage() {
        return this.message;
    }

    public Course getCourse() { return course; }
}
