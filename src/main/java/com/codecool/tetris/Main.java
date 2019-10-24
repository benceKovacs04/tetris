package com.codecool.tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane rootPane = new Pane();

        Stash stash = new Stash();
        stash.init();
        Queue queue = new Queue();
        queue.init();
        Game game = new Game(stash, queue);

        InputHandler inputHandler = new InputHandler(primaryStage);
        inputHandler.initInputHandlers(game);

        game.spawnNewActiveTetromino();
        game.drawActiveAndShadowPieces();

        rootPane.getChildren().addAll(stash, game, queue);


        primaryStage.setScene(new Scene(rootPane, 800, 600));
        primaryStage.show();

        game.init();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
