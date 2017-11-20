package objects;

import java.io.Serializable;

public class CourseNoteComment implements Serializable {
    public static final long serialVersionUID = 102134;
    private Course course;
    private Note note;
    private Comment comment;

    public CourseNoteComment(Course course, Note note, Comment comment) {
        this.course = course;
        this.note = note;
        this.comment = comment;
    }

    public Course getCourse() {
        return course;
    }

    public Comment getComment() {
        return comment;
    }

    public Note getNote() {
        return note;
    }
}
