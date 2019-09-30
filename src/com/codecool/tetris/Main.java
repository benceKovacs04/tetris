package com.codecool.tetris;

import com.codecool.tetromino.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game();

        ZTetro tetro = new ZTetro();
        game.drawPiece(tetro);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case A:
                    tetro.move(Direction.LEFT);
                    game.drawPiece(tetro);
                    break;
                case D:
                    tetro.move(Direction.RIGHT);
                    game.drawPiece(tetro);
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
