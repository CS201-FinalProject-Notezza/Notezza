package objects;

import java.util.Set;
import java.util.Vector;

public class Quiz {
    private String question;
    private Vector<String> choices;
    private Set<Integer> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Vector<String> getChoices() {
        return choices;
    }

    public void setChoices(Vector<String> choices) {
        this.choices = choices;
    }

    public Set<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Integer> answers) {
        this.answers = answers;
    }
}
