package model;

public class Player {

    private String name;
    private int score;

    public Player(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setScore(int s) {
        score = s;
    }

    public int getScore() {
        return score;
    }
}
