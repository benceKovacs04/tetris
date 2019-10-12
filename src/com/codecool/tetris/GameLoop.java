package com.codecool.tetris;

public class GameLoop {

    private GameTick game;

    public GameLoop(GameTick game) {
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
