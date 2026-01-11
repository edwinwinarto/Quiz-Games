package view;

import controller.MenuController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Category;

public class MenuView extends VBox {

    private VBox card;

    public MenuView() {
        setAlignment(Pos.CENTER); // posisi MenuView di tengah
        setSpacing(0);

        card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(30));
        card.getStyleClass().add("card");
        card.setMaxWidth(400); // lebar card

        for (Category c : Category.values()) {
            Button b = new Button(c.getLabel());
            b.getStyleClass().add("menu-button");
            b.setPrefWidth(250); // button tidak panjang
            b.setOnAction(e -> MenuController.start(c));
            card.getChildren().add(b);
        }

        getChildren().add(card);
    }
}