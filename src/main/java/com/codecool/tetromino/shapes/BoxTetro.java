package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.Tetromino;
import javafx.scene.paint.Color;

import java.util.Map;

public class BoxTetro extends Tetromino {

    public BoxTetro(TetrominoHandler game) {
        super(game);

        PONE_COL = 4;
        PONE_ROW = 0;

        PTWO_COL = 5;
        PTWO_ROW = 0;

        PTHREE_COL = 4;
        PTHREE_ROW = 1;

        PFOUR_COL = 5;
        PFOUR_ROW = 1;

        setDefaultPosition();

        pieceOne.setSpecialGridColNum(2);
        pieceOne.setSpecialGridRowNum(2);

        pieceTwo.setSpecialGridColNum(3);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(2);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(3);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.YELLOW);
        pieceOne.setStroke(Color.LIGHTGREY);
        pieceTwo.setFill(Color.YELLOW);
        pieceTwo.setStroke(Color.LIGHTGREY);
        pieceThree.setFill(Color.YELLOW);
        pieceThree.setStroke(Color.LIGHTGREY);
        pieceFour.setFill(Color.YELLOW);
        pieceFour.setStroke(Color.LIGHTGREY);
    }

    @Override
    public void transform() {

    }


}
