package model;

import java.util.List;

public class ChoiceQuestion extends Question {

    private final List<String> choices;

    public ChoiceQuestion(String q, List<String> c, String a) {
        this.question = q;
        this.choices = c;
        this.answer = a;
    }

    public List<String> getChoices() {
        return choices;
    }

    @Override
    public boolean isCorrect(String input) {
        return input != null && input.equalsIgnoreCase(answer);
    }
}
