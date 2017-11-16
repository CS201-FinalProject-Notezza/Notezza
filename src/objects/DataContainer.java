package objects;

import java.util.Vector;

public class DataContainer {
    private Vector<User> allUsers;
    private Vector<Course> allCourses;

    public DataContainer() {
    	
    }

    public Vector<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(Vector<User> allUsers) {
        this.allUsers = allUsers;
    }

    public Vector<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(Vector<Course> allCourses) {
        this.allCourses = allCourses;
    }

}