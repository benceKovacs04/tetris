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

    public boolean isRunning() {
        return running;
    }

    public void step() {
        if (running) {
            game.step();
        }
    }

}
