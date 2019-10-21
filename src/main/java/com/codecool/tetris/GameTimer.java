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

    public GameTimer(Runnable loopMethod) {
        this.loopMethod = loopMethod;
    }

    public void startDefault() {
        timer.setCycleCount(Timeline.INDEFINITE);
        frameTime = DEFAULT_SPEED;
        addKeyFrame();
        timer.play();
    }

    private void addKeyFrame() {
        this.keyframe = new KeyFrame(
                Duration.seconds(frameTime),
                ae -> loopMethod.run());

        timer.getKeyFrames().add(keyframe);
    }

    public void updateSpeed(double frameTime) {
        this.frameTime = frameTime;
        timer.stop();
        timer.getKeyFrames().remove(keyframe);
        addKeyFrame();
        timer.play();
    }

}
