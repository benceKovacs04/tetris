package com.codecool.tetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameTimer {

    private static final double DEFAULT_SPEED = 0.5;
    private double frameTime;
    private Timeline timer = new Timeline();
    private Runnable loopMethod;

    GameTimer() {
        this(DEFAULT_SPEED);
    }

    GameTimer(double frameTime) {
        this.frameTime = frameTime;
    }

    public void setup (Runnable loopMethod) {
        this.loopMethod = loopMethod;
        timer.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyframe = new KeyFrame(
                Duration.seconds(frameTime),
                ae -> loopMethod.run());

        timer.getKeyFrames().add(keyframe);
    }

    public void updateSpeed(double frameTime) {
        this.frameTime = frameTime;
        setup(loopMethod);
    }

    public void play() {
        timer.play();
    }

}
