package objects;

import java.util.Vector;

public class User {
    private String fname;
    private String lname;
    private String username;
    private String email;
    private long password;
    private boolean isInstructor;
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
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
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

    public boolean isInstructor() {
        return isInstructor;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course){
        if (courses != null) {
            courses.add(course);
        } else {
            courses = new Vector<>();
            courses.add(course);
        }
    }

}
