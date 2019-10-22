package com.codecool.tetris;

import com.codecool.tetromino.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Game game = new Game();
        InputHandler inputHandler = new InputHandler(primaryStage);
        inputHandler.initInputHandlers(game);

        game.spawnNewActiveTetromino();
        game.drawActivePiece();


        primaryStage.setScene(new Scene(game, 800, 600));
        primaryStage.show();

        game.init();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
