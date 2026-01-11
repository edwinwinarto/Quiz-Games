package view;

import app.SceneManager;
import controller.QuizController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Quiz;

public class ResultView extends StackPane {

    public ResultView() {

        Quiz quiz = QuizController.getQuiz();

        VBox card = new VBox(15);
        card.getStyleClass().add("card");
        card.setAlignment(Pos.CENTER);
        card.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Label title = new Label("HASIL QUIZ");
        title.getStyleClass().add("title");

        Label benar = new Label("Benar : " + quiz.getCorrect());
        Label total = new Label("Total : " + quiz.getTotal());
        Label nilai = new Label("Nilai : " + quiz.getScore() + "%");

        Button back = new Button("KEMBALI KE MENU");
        back.setOnAction(e -> SceneManager.showMenu());

        card.getChildren().addAll(
                title,
                benar,
                total,
                nilai,
                back
        );

        setAlignment(Pos.CENTER);
        getChildren().add(card);
        widthProperty().addListener((o, ov, nv) ->
        StackPane.setMargin(card, new Insets(nv.doubleValue() * 0.15))
    );
    }
}
