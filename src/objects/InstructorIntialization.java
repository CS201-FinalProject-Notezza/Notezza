package objects;

import java.util.List;
import java.util.Set;

public class InstructorIntialization {
    public static final long serialVersionUID = 1234;
    private List<Course> course;
    private Set<User> allUsers;

    public InstructorIntialization(List<Course> course, Set<User> users) {
        this.course = course;
        this.allUsers = users;
    }

    public List<Course> getCourse() {
        return course;
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }
}
