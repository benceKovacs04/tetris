package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

import java.util.Map;

public class TTetro extends Tetromino {

    public TTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(1);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(1);

        pieceThree.setColNum(5);
        pieceThree.setRowNum(0);

        pieceFour.setColNum(6);
        pieceFour.setRowNum(1);

        pieceOne.setFill(Color.PURPLE);
        pieceTwo.setFill(Color.PURPLE);
        pieceThree.setFill(Color.PURPLE);
        pieceFour.setFill(Color.PURPLE);
    }

    @Override
    public void transform() {
        //TODO: implement it
    }
}


