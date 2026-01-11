package app;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.*;

public class SceneManager {

    private static Stage stage;
    private static StackPane root;
    private static Scene scene;

    public static void setStage(Stage s) {
        stage = s;

        root = new StackPane();
        root.setPrefSize(1000, 700);
        root.setMinSize(1000, 700);
        root.setMaxSize(1000, 700);

        scene = new Scene(root);
        scene.getStylesheets().add(
            SceneManager.class
                .getResource("/style/style.css")
                .toExternalForm()
        );

        stage.setScene(scene);
        stage.setResizable(false);
    }

    public static void showLogin() {
        rootSet(new LoginView());
    }

    public static void showMenu() {
        rootSet(new MenuView());
    }

    public static void showQuiz() {
        rootSet(new QuizView());
    }

    public static void showResult() {
        rootSet(new ResultView());
    }

    private static void rootSet(javafx.scene.Parent view) {

        if (view instanceof javafx.scene.layout.Region r) {
            r.prefWidthProperty().bind(root.widthProperty());
            r.prefHeightProperty().bind(root.heightProperty());
        }

        root.getChildren().setAll(view);
    }

}
