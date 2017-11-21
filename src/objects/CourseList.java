package objects;

import java.io.Serializable;
import java.util.Vector;

public class CourseList implements Serializable {
    public static final long serialVersionUID = 12341234;
    private Vector<Course> course;

    public CourseList(Vector<Course> course) {
        this.course = course;
    }

    public Vector<Course> getCourses() {
        return course;
    }
    
    public void addACourse(Course courseToAdd) {
    		this.course.add(courseToAdd);
    }
}
