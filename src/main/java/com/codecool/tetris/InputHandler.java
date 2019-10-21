package com.codecool.tetris;

import com.codecool.tetromino.Direction;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class InputHandler {

    Stage primaryStage;

    public InputHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initInputHandlers(TetrominoHandler game) {
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case A:
                    game.moveTetromino(Direction.LEFT);
                    break;
                case D:
                    game.moveTetromino(Direction.RIGHT);
                    break;
                case W:
                    game.moveTetromino(Direction.TRANSFORM);
                    break;
                case S:
                    game.moveTetromino(Direction.BOTTOM);
                    break;
            }
        });
    }
}
