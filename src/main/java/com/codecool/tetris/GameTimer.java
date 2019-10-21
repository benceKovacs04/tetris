package com.codecool.tetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.security.Key;

public class GameTimer {

    private static final double DEFAULT_SPEED = 0.5;
    private double frameTime;
    private Timeline timer = new Timeline();
    private KeyFrame keyframe;
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

        this.keyframe = new KeyFrame(
                Duration.seconds(frameTime),
                ae -> loopMethod.run());

        timer.getKeyFrames().add(keyframe);
    }

    public void updateSpeed(double frameTime) {
        this.frameTime = frameTime;
        timer.getKeyFrames().remove(keyframe);
        setup(loopMethod);
        timer.getKeyFrames().get(0).
    }

    public void play() {
        timer.play();
    }

}
