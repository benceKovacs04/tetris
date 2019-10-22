package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.Tetromino;
import javafx.scene.paint.Color;

import java.util.Map;

public class BoxTetro extends Tetromino {

    public BoxTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(0);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(0);

        pieceThree.setColNum(4);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(5);
        pieceFour.setRowNum(1);

        pieceOne.setSpecialGridColNum(2);
        pieceOne.setSpecialGridRowNum(2);

        pieceTwo.setSpecialGridColNum(3);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(2);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(3);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.YELLOW);
        pieceTwo.setFill(Color.YELLOW);
        pieceThree.setFill(Color.YELLOW);
        pieceFour.setFill(Color.YELLOW);
    }

    @Override
    public void transform() {

    }


}
