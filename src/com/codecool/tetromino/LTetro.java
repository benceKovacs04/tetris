package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

public class LTetro extends Tetromino {

    public LTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(0);

        pieceTwo.setColNum(4);
        pieceTwo.setRowNum(1);

        pieceThree.setColNum(5);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(6);
        pieceFour.setRowNum(1);

        pieceOne.setFill(Color.BLUE);
        pieceTwo.setFill(Color.BLUE);
        pieceThree.setFill(Color.BLUE);
        pieceFour.setFill(Color.BLUE);
    }


    @Override
    public void transform() {
        //TODO: Implement it
    }
}
