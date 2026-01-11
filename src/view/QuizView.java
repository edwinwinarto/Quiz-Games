package view;

import controller.QuizController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.*;

public class QuizView extends VBox {

    private int time = 15;
    private Timeline timeline;

    public QuizView() {

        setAlignment(Pos.CENTER);

        /* ===== CARD ===== */
        VBox card = new VBox(20);
        card.getStyleClass().add("card");
        card.setAlignment(Pos.TOP_CENTER);
        card.setMaxWidth(600);
        card.setPrefWidth(600);

        /* ===== DATA ===== */
        Quiz quiz = QuizController.getQuiz();
        Question q = QuizController.current();

        /* ===== TIMER (ANGKA SAJA) ===== */
        Label timer = new Label(String.valueOf(time));
        timer.getStyleClass().add("quiz-timer");

        /* ===== INFO ===== */
        Label info = new Label("Soal " + quiz.getIndex() + " / " + quiz.getTotal());

        /* ===== SOAL ===== */
        Label soal = new Label(q.getQuestion());
        soal.setWrapText(true);
        soal.setAlignment(Pos.CENTER);
        soal.setMaxWidth(520);

        card.getChildren().addAll(timer, info, soal);

        /* ===== TIMER LOGIC ===== */
        timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                time--;
                timer.setText(String.valueOf(time));

                if (time <= 0) {
                    timeline.stop();
                    QuizController.submit("");
                }
            })
        );
        timeline.setCycleCount(time);
        timeline.play();

        /* ===== PILIHAN GANDA ===== */
        if (q instanceof ChoiceQuestion cq) {

            ToggleGroup g = new ToggleGroup();

            for (String c : cq.getChoices()) {
                RadioButton rb = new RadioButton(c);
                rb.setToggleGroup(g);
                card.getChildren().add(rb);
            }

            Button next = new Button("NEXT");
            next.getStyleClass().add("menu-button");
            next.setDisable(true);

            g.selectedToggleProperty().addListener((obs, old, val) ->
                next.setDisable(val == null)
            );

            next.setOnAction(e -> {
                timeline.stop();
                RadioButton r = (RadioButton) g.getSelectedToggle();
                QuizController.submit(r.getText());
            });

            card.getChildren().add(next);
        }

        /* ===== ISIAN ===== */
        else {
            TextField tf = new TextField();
            tf.setPromptText("Masukkan jawaban...");
            tf.setMaxWidth(300);

            Button next = new Button("NEXT");
            next.getStyleClass().add("menu-button");
            next.setDisable(true);

            tf.textProperty().addListener((obs, old, val) ->
                next.setDisable(val.trim().isEmpty())
            );

            next.setOnAction(e -> {
                timeline.stop();
                QuizController.submit(tf.getText());
            });

            card.getChildren().addAll(tf, next);
        }

        getChildren().add(card);
    }
}
