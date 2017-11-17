package objects;

public class CourseANDNote {
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
