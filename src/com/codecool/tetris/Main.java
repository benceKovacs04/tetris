package com.codecool.tetris;

import com.codecool.tetromino.Box;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game();

        Box box = new Box();
        game.drawPiece(box);


        primaryStage.setScene(new Scene(game, 800, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
