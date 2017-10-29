package objects;

import java.util.Vector;

public class Course {
    private final String courseName;
    private final User instructor;
    private final Vector<User> students;
    private Vector<Note> allNotes;
    private Presentation currentLecture;

    // We also need a sort && search method maybe here or other places

    public Course(String courseName, User instructor, Vector<User> students) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public User getInstructor() {
        return instructor;
    }

    public Vector<User> getStudents() {
        return students;
    }

    public Vector<Note> getAllNotes() {
        return allNotes;
    }

    public void setAllNotes(Vector<Note> allNotes) {
        this.allNotes = allNotes;
    }

    public Presentation getCurrentLecture() {
        return currentLecture;
    }

    public void setCurrentLecture(Presentation currentLecture) {
        this.currentLecture = currentLecture;
    }

    // I don't know what this does either
    public Vector<Note> getFeeds() {
        Vector<Note> feeds = new Vector<>();

        return feeds;
    }

    //NEEEEEEEEEEEEED IMPLLEEEEEEEEEEMENTATIONNNNNNN
    public Vector<Note> searchNote(String keyword) {
        Vector<Note> notes = new Vector<>();

        return notes;
    }

    public void addNote(Note note) {
        if (allNotes == null) {
            allNotes = new Vector<>();
        }
        allNotes.add(note);
    }
}
