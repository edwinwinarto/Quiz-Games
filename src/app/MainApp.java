package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.setStage(stage);
        SceneManager.showLogin();
        stage.setTitle("Quiz Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
