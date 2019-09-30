package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

public class ColTetro extends Tetromino {

    private int state = 1;

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
        switch (state) {
            case 1:
                if (pieceOne.getColNum() < COLNUMBER - 2 && pieceFour.getColNum() > 0) {
                    pieceOne.setColNum(pieceOne.getColNum() + 2);
                    pieceOne.setRowNum(pieceOne.getRowNum() + 2);

                    pieceTwo.setColNum(pieceTwo.getColNum() + 1);
                    pieceTwo.setRowNum(pieceTwo.getRowNum() + 1);

                    pieceFour.setColNum(pieceFour.getColNum() - 1);
                    pieceFour.setRowNum(pieceFour.getRowNum() - 1);
                    state = 2;
                }
                break;
            case 2:
                pieceOne.setColNum(pieceOne.getColNum() - 2);
                pieceOne.setRowNum(pieceOne.getRowNum() - 2);

                pieceTwo.setColNum(pieceTwo.getColNum() - 1);
                pieceTwo.setRowNum(pieceTwo.getRowNum() - 1);

                pieceFour.setColNum(pieceFour.getColNum() + 1);
                pieceFour.setRowNum(pieceFour.getRowNum() + 1);
                state = 1;
                break;
        }
    }
}
