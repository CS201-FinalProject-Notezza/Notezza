package objects;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

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
    
    public List<Course> findUserCourses(String name){
        List<Course> courses= new ArrayList<>();
        for(Course course : allCourses.values()) {
            if(course.containStudent(name)){
                courses.add(course);
            }
        }
        return courses;
    }
    
    public List<Course> findInstructorCourses(String name) {
        List<Course> courses= new ArrayList<>();
        for(Course course : allCourses.values()) {
            if(course.getInstructor().getUsername().equals(name)){
                courses.add(course);
            }
        }
        return courses;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Course course : allCourses.values()) {
            sb.append(course.getCourseName()).append("\n");
        }
        for(User user : allUsers.values()) {
            sb.append(user.getUsername()).append("\n");
        }
        return sb.toString();
    }


}