package objects;

import java.io.Serializable;

public class AddingLike implements Serializable {
    public static final long serialVersionUID = 15319;
    private User user;
    private Note note;

    public AddingLike(User user, Note note) {
        this.user = user;
        this.note = note;
    }

    public User getUser() { return user; }

    public Note getNote() { return note; }
}
