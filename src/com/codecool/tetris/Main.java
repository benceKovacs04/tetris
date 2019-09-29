package com.codecool.tetris;

import com.codecool.tetromino.Box;
import com.codecool.tetromino.Direction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game();

        Box box = new Box();
        game.drawPiece(box);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case A:
                    box.move(Direction.LEFT);
                    game.drawPiece(box);
                    break;
                case D:
                    box.move(Direction.RIGHT);
                    game.drawPiece(box);
                    break;
            }
        });


        primaryStage.setScene(new Scene(game, 800, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
