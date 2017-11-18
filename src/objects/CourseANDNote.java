package objects;

import java.io.Serializable;

public class CourseANDNote implements Serializable {
    public static final long serialVersionUID = 101;
    private Course course;
    private Note note;

    public CourseANDNote(Course course, Note note) {
        this.course = course;
        this.note = note;
    }

    public Course getCourse() {
        return course;
    }

    public Note getNote() {
        return note;
    }
}
