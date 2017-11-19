package objects;

import java.io.Serializable;
import java.util.Vector;

public class CreateClassInfo implements Serializable {
    public static final long serialVersionUID = 42;
    private String courseName;
    private String[] emails;
    private User instructor;

    public CreateClassInfo(String courseName, String[] emails, User instructor) {
        this.courseName = courseName;
        this.emails = emails;
        this.instructor = instructor;
    }

    public String getCourseName() { return courseName; }

    public String[] getEmails() { return emails; }

    public User getInstructor() { return instructor; }
}
