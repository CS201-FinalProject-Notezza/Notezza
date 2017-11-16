package objects;

import java.io.Serializable;
import java.util.List;

public class CourseList implements Serializable {
    public static final long serialVersionUID = 12341234;
    private List<Course> course;

    public CourseList(List<Course> course) {
        this.course = course;
    }

    public List<Course> getCourse() {
        return course;
    }
}
