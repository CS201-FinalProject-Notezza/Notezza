package objects;

import java.io.Serializable;
import java.util.Collections;
import java.util.Vector;

public class Course implements Serializable {
    public static final long serialVersionUID = 1;
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
        this.allNotes = new Vector<>();
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
    
    
    // Returns a vector of notes that contains certain keywords.
    public Vector<Note> searchNote(String keyword) {
        Vector<Note> notes = new Vector<>();
        // split keywords
        String[] keywords = keyword.split("\\s+");
        // substring search
        for (Note note : notes) {
            if (note.containKeywords(keywords)) {
                notes.add(note);
            }
        }
        return notes;
    }
    
    public void addNote(Note note) { allNotes.add(note);}
    
    public boolean containStudent(String username){
        for (User student : students) {
            if(student.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    public Vector<Note> sortNotes(SortType type){
		Vector<Note> tempNotes = new Vector<Note>(allNotes);
		for (Note note : tempNotes) {
			note.setSortBy(type);
		}
		Collections.sort(tempNotes);
		return tempNotes;
    }
    
    
}
