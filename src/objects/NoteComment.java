package objects;

public class NoteComment {
    private Note note;
    private Comment comment;

    public Note getNote() {
        return note;
    }

    public Comment getComment() {
        return comment;
    }

    public NoteComment(Note note, Comment comment) {

        this.note = note;
        this.comment = comment;
    }
}
