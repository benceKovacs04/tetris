package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

import java.util.Map;

public class ZTetro extends Tetromino {

    public ZTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(0);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(0);

        pieceThree.setColNum(5);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(6);
        pieceFour.setRowNum(1);

        pieceOne.setFill(Color.RED);
        pieceTwo.setFill(Color.RED);
        pieceThree.setFill(Color.RED);
        pieceFour.setFill(Color.RED
        );
    }

    @Override
    public void transform() {
        //TODO: implement
    }
}
