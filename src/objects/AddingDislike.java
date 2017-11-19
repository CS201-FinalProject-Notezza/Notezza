package objects;

import java.io.Serializable;

public class AddingDislike implements Serializable {
    public static final long serialVersionUID = 15320;

    private User user;
    private Note note;

    public AddingDislike(User user, Note note) {
        this.user = user;
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public Note getNote() {
        return note;
    }
}
