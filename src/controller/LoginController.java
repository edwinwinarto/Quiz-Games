package controller;

import app.SceneManager;
import model.Player;

public class LoginController {

    private static Player player;

    public static void login(String name) {
        if (name == null || name.trim().isEmpty()) return;

        player = new Player(name.trim());

        QuizController.setPlayer(player);

        SceneManager.showMenu();
    }

    public static Player getPlayer() {
        return player;
    }
}
