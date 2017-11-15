package objects;

import java.util.Map;
import java.util.Set;

public class DataContainer {
    private Map<String,User> allUsers;
    private Set<Course> allCourses;

    // Leave this to TIMMMMMMMMMMMMM
    public DataContainer() {

    }

    public Map<String, User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(Map<String, User> allUsers) {
        this.allUsers = allUsers;
    }

    public Set<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(Set<Course> allCourses) {
        this.allCourses = allCourses;
    }

}

