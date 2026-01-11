package model;

public abstract class Question {
    protected String question;
    protected String answer;

    public String getQuestion() {
        return question;
    }

    public abstract boolean isCorrect(String input);
}
