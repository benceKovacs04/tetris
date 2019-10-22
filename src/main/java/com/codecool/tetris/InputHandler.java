package com.codecool.tetris;

import com.codecool.tetromino.Actions;
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
                    game.moveTetromino(Actions.LEFT);
                    break;
                case D:
                    game.moveTetromino(Actions.RIGHT);
                    break;
                case W:
                    game.moveTetromino(Actions.TRANSFORM);
                    break;
                case S:
                    game.moveTetromino(Actions.BOTTOM);
                    break;
                case E:
                    game.moveTetromino(Actions.STASH);
            }
        });
    }
}
