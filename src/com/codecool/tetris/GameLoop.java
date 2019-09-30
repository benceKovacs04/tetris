package com.codecool.tetris;

public class GameLoop {

    private Gameplay game;

    public GameLoop(Gameplay game) {
        this.game = game;
    }

    private boolean running = false;

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void step() {
        game.step();
    }

}
