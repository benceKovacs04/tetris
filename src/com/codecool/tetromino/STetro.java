package com.codecool.tetromino;

import javafx.scene.paint.Color;

public class STetro extends Tetromino {

    public STetro() {
        pieceOne.setColNum(4);
        pieceOne.setRowNum(1);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(1);

        pieceThree.setColNum(5);
        pieceThree.setRowNum(0);

        pieceFour.setColNum(6);
        pieceFour.setRowNum(0);

        pieceOne.setFill(Color.GREEN);
        pieceTwo.setFill(Color.GREEN);
        pieceThree.setFill(Color.GREEN);
        pieceFour.setFill(Color.GREEN);
    }

    @Override
    public void transform() {
        //TODO: implement
    }
}