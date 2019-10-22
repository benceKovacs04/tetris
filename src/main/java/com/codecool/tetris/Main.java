package com.codecool.tetris;

import com.codecool.tetromino.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        Stash stash = new Stash();
        Game game = new Game(stash);

        InputHandler inputHandler = new InputHandler(primaryStage);
        inputHandler.initInputHandlers(game);

        game.spawnNewActiveTetromino();
        game.drawActivePiece();

        pane.getChildren().addAll(game, stash);


        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();

        game.init();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
