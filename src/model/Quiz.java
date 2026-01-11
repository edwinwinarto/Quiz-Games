package model;

import java.util.List;

public class Quiz {

    private final List<Question> questions;
    private int index = 0;
    private int correct = 0;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public Question getCurrentQuestion() {
        return questions.get(index);
    }

    public void answer(String input) {
        if (getCurrentQuestion().isCorrect(input)) {
            correct++;
        }
        index++;
    }

    public boolean hasNext() {
        return index < questions.size();
    }

    public int getIndex() {
        return index + 1;
    }

    public int getTotal() {
        return questions.size();
    }

    public int getCorrect() {
        return correct;
    }

    public int getScore() {
        if (questions.isEmpty()) return 0;
        return (int) Math.round((correct * 100.0) / questions.size());
    }
}
