package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

import java.util.Map;

public class JTetro extends CenterPieceTetromino {

    public JTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(0);

        pieceTwo.setColNum(4);
        pieceTwo.setRowNum(1);

        pieceThree.setColNum(6);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(5);
        pieceFour.setRowNum(1);

        pieceOne.setFill(Color.BLUE);
        pieceTwo.setFill(Color.BLUE);
        pieceThree.setFill(Color.BLUE);
        pieceFour.setFill(Color.BLUE);
    }

    //private boolean stateOneValidMove

    @Override
    public void transform() {
        switch (state) {
            case 1:
                if(middlePieceInBounds()) {
                    pieceOne.setColNum(pieceOne.getColNum() + 2);

                    pieceTwo.setRowNum(pieceTwo.getRowNum() - 1);
                    pieceTwo.setColNum(pieceTwo.getColNum() + 1);

                    pieceThree.setRowNum(pieceThree.getRowNum() + 1);
                    pieceThree.setColNum(pieceThree.getColNum() - 1);
                    state = 2;
                }
                break;
            case 2:
                if (middlePieceInBounds()) {
                    pieceOne.setRowNum(pieceOne.getRowNum() + 2);

                    pieceTwo.setRowNum(pieceTwo.getRowNum() + 1);
                    pieceTwo.setColNum(pieceTwo.getColNum() + 1);

                    pieceThree.setRowNum(pieceThree.getRowNum() - 1);
                    pieceThree.setColNum(pieceThree.getColNum() - 1);
                    state = 3;
                }
                break;
            case 3:
                if (middlePieceInBounds()) {
                    pieceOne.setColNum(pieceOne.getColNum() - 2);

                    pieceTwo.setRowNum(pieceTwo.getRowNum() + 1);
                    pieceTwo.setColNum(pieceTwo.getColNum() - 1);

                    pieceThree.setRowNum(pieceThree.getRowNum() - 1);
                    pieceThree.setColNum(pieceThree.getColNum() + 1);
                    state = 4;
                }
                break;
            case 4:
                if (middlePieceInBounds()) {
                    pieceOne.setRowNum(pieceOne.getRowNum() - 2);

                    pieceTwo.setRowNum(pieceTwo.getRowNum() - 1);
                    pieceTwo.setColNum(pieceTwo.getColNum() - 1);

                    pieceThree.setRowNum(pieceThree.getRowNum() + 1);
                    pieceThree.setColNum(pieceThree.getColNum() + 1);
                    state = 1;
                }
                break;

        }
    }

}
