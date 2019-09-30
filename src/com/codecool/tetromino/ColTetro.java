package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

public class ColTetro extends Tetromino {

    public ColTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(0);

        pieceTwo.setColNum(4);
        pieceTwo.setRowNum(1);

        pieceThree.setColNum(4);
        pieceThree.setRowNum(2);

        pieceFour.setColNum(4);
        pieceFour.setRowNum(3);

        pieceOne.setFill(Color.AQUA);
        pieceTwo.setFill(Color.AQUA);
        pieceThree.setFill(Color.AQUA);
        pieceFour.setFill(Color.AQUA);
    }

    @Override
    public void transform() {
        //TODO: implement transform
    }
}
