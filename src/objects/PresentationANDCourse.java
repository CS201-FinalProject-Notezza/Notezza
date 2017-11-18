package objects;

import java.io.Serializable;

public class PresentationANDCourse implements Serializable {
    public static final long serialVersionUID = 100;
    private Presentation presentation;
    private Course course;

    public PresentationANDCourse(Presentation presentation, Course course) {
        this.presentation = presentation;
        this.course = course;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public Course getCourse() {
        return course;
    }
}
