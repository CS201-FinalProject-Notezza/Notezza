package objects;

import java.util.Vector;

public class User implements Serializable{
    public static final long serialVersionUID = 2;
    private final String fname;
    private final String lname;
    private final String username;
    private final String email;
    private long password;
    private final boolean isInstructor;
    private boolean isVisible;
    private Vector<Course> courses;
    
    public User(String fname, String lname, String username, String email, long password, boolean isInstructor, boolean isVisible) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isInstructor = isInstructor;
        this.isVisible = isVisible;
        this.courses = new Vector<>();
    }
    
    public void setPassword(long password) {
        this.password = password;
    }
    
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
    
    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }
    
    public String getFname() {
        return fname;
    }
    
    public String getLname() {
        return lname;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public long getPassword() {
        return password;
    }
    
    public boolean isInstructor() { return isInstructor; }
    
    public boolean isVisible() {
        return isVisible;
    }
    
    public Vector<Course> getCourses() {
        return courses;
    }
    
    public void addCourse(Course course){ courses.add(course); }
    
}
