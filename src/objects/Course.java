package objects;

import java.util.Vector;

public class Course {
    private String courseName;
    private User instructor;
    private Vector<User> students;
    private Vector<Note> allNotes;
    private Presentation currentLecture;
    private Vector<Note> sortedNotesByDate;
    private Vector<Note> sortedNotesByNumComments;
    private Vector<Note> sortedNotesByNumLikes;

    public Course(String courseName, User instructor, Vector<User> students) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public Vector<User> getStudents() {
        return students;
    }

    public void setStudents(Vector<User> students) {
        this.students = students;
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

    public Vector<Note> getSortedNotesByDate() {
        return sortedNotesByDate;
    }

    public void setSortedNotesByDate(Vector<Note> sortedNotesByDate) {
        this.sortedNotesByDate = sortedNotesByDate;
    }

    public Vector<Note> getSortedNotesByNumComments() {
        return sortedNotesByNumComments;
    }

    public void setSortedNotesByNumComments(Vector<Note> sortedNotesByNumComments) { this.sortedNotesByNumComments = sortedNotesByNumComments; }

    public Vector<Note> getSortedNotesByNumLikes() {
        return sortedNotesByNumLikes;
    }

    public void setSortedNotesByNumLikes(Vector<Note> sortedNotesByNumLikes) { this.sortedNotesByNumLikes = sortedNotesByNumLikes; }

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
