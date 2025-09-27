package org.game;

public class Game {
    private final Board board;
    private final Player p1;
    private final Player p2;
    private Player current;

    public Game(int n, Player p1, Player p2) {
        this.board = new Board(n);
        this.p1 = p1;
        this.p2 = p2;
        this.current = p1;
    }

    public void runGame() {

    }

    private void switchPlayer() {
        current = current == p1 ? p2 : p1;
    }
}
