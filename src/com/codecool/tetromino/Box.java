package com.codecool.tetromino;

import javafx.scene.paint.Color;

public class Box extends Tetromino {

    public Box() {
        pieceOne.setColNum(4);
        pieceOne.setRowNum(0);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(0);

        pieceThree.setColNum(4);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(5);
        pieceFour.setRowNum(1);

        pieceOne.setFill(Color.YELLOW);
        pieceTwo.setFill(Color.YELLOW);
        pieceThree.setFill(Color.YELLOW);
        pieceFour.setFill(Color.YELLOW);
    }

    @Override
    public void move(Direction direction) {
        //TODO: do movement
        ;
    }

    @Override
    public void transform() {
        //TODO: do transformation
        ;
    }
}
