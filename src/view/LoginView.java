package view;

import controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginView extends StackPane {

    public LoginView() {
        getStylesheets().add("style/style.css");

        VBox card = new VBox(20);
        card.getStyleClass().add("card");
        card.setAlignment(Pos.CENTER);
        card.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label title = new Label("QUIZ GAME");
        title.getStyleClass().add("title");

        TextField name = new TextField();
        name.setPromptText("Your Name");
        name.setMaxWidth(Double.MAX_VALUE);

        Button start = new Button("START");
        start.setMaxWidth(Double.MAX_VALUE);
        start.setOnAction(e -> LoginController.login(name.getText()));

        card.getChildren().addAll(title, name, start);
        getChildren().add(card);

        widthProperty().addListener((o, ov, nv) ->
            StackPane.setMargin(card, new Insets(nv.doubleValue() * 0.15))
        );
    }
}
