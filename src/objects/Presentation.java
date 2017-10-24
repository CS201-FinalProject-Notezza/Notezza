package objects;

import java.util.Vector;

public class Presentation {
    private Vector<String> links;
    private Vector<Quiz> quizzes;

    public Presentation(Vector<String> links, Vector<Quiz> quizzes) {
        this.links = links;
        this.quizzes = quizzes;
    }

    public Vector<String> getLinks() {
        return links;
    }

    public void setLinks(Vector<String> links) {
        this.links = links;
    }

    public Vector<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Vector<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
