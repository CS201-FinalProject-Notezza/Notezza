package objects;

import java.util.Map;

public class DataContainer {
    private Map<String, User> allUsers;
    private Map<String, Course> allCourses;

    public DataContainer() {
    	
    }

    public Map<String, User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(Map<String, User> allUsers) {
        this.allUsers = allUsers;
    }

    public Map<String, Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(Map<String, Course> allCourses) {
        this.allCourses = allCourses;
    }

}