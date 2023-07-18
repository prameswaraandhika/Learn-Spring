package com.springdasar.demo;

public class GameRunner {
    // MarioGame game;
    GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.startGame();
    }

}
