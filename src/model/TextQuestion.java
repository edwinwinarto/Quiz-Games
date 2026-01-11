package model;

public class TextQuestion extends Question {

    public TextQuestion(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    @Override
    public boolean isCorrect(String input) {
        return input != null && input.trim().equalsIgnoreCase(answer.trim());
    }
}
