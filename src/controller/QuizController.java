package controller;

import util.ResultWriter;
import app.SceneManager;
import model.Quiz;
import model.Player;
import model.Question;

public class QuizController {

    private static Quiz quiz;
    private static Player player;
    private static String categoryName;

    public static void start(Quiz q) {
        quiz = q;
        SceneManager.showQuiz();
    }

    public static Question current() {
        return quiz.getCurrentQuestion();
    }

    public static Quiz getQuiz() {
        return quiz;
    }

    public static void setPlayer(Player p) {
        player = p;
    }

    public static void setCategory(String c) {
        categoryName = c;
    }

    public static void submit(String ans) {
        quiz.answer(ans);

        if (quiz.hasNext()) {
            SceneManager.showQuiz();
        } else {

            String nama = (player != null)
                    ? player.getName()
                    : "Unknown";

            String kategori = categoryName;
            int score = quiz.getScore();

            ResultWriter.save(nama, kategori, score);
            SceneManager.showResult();
        }
    }

}
