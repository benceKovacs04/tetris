package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

import java.util.Map;

public class LTetro extends Tetromino {

    public LTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(1);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(1);

        pieceThree.setColNum(6);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(6);
        pieceFour.setRowNum(0);


        pieceOne.setFill(Color.ORANGE);
        pieceTwo.setFill(Color.ORANGE);
        pieceThree.setFill(Color.ORANGE);
        pieceFour.setFill(Color.ORANGE);
    }


    @Override
    public void transform() {
        //TODO: Implement it
    }


}
