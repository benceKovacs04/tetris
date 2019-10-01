package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Map;

public class TTetro extends Tetromino {

    private int state = 1;

    public TTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(1);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(0);

        pieceThree.setColNum(6);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(5);
        pieceFour.setRowNum(1);

        pieceOne.setFill(Color.PURPLE);
        pieceTwo.setFill(Color.PURPLE);
        pieceThree.setFill(Color.PURPLE);
        pieceFour.setFill(Color.PURPLE);
    }

    private boolean middlePieceInBounds() {
        return pieceFour.getRowNum() < ROWNUMBER - 1 && pieceFour.getRowNum() > 0 &&
                pieceFour.getColNum() <= COLNUMBER - 2 && pieceFour.getColNum() > 0;
    }

    private void transformFirstTwoPiece() {
        pieceOne.setColNum(pieceTwo.getColNum());
        pieceOne.setRowNum(pieceTwo.getRowNum());

        pieceTwo.setColNum(pieceThree.getColNum());
        pieceTwo.setRowNum(pieceThree.getRowNum());
    }

    @Override
    public void transform() {
        switch (state) {
            case 1:
                if (checkForValidTransform(Map.of("thirdPiece", Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() -1)))
                        && middlePieceInBounds()) {
                    transformFirstTwoPiece();
                    pieceThree.setRowNum(pieceThree.getRowNum() + 1);
                    pieceThree.setColNum(pieceThree.getColNum() - 1);
                    state = 2;
                }
                break;
            case 2:
                if (checkForValidTransform(Map.of("thirdPiece", Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1)))
                        && middlePieceInBounds()) {
                    transformFirstTwoPiece();
                    pieceThree.setRowNum(pieceThree.getRowNum() - 1);
                    pieceThree.setColNum(pieceThree.getColNum() - 1);
                    state = 3;
                }
                break;
            case 3:
                if (checkForValidTransform(Map.of("thirdPiece", Arrays.asList(pieceThree.getRowNum() - 1 , pieceThree.getColNum() + 1)))
                        && middlePieceInBounds()
                ) {
                    transformFirstTwoPiece();
                    pieceThree.setRowNum(pieceThree.getRowNum() - 1);
                    pieceThree.setColNum(pieceThree.getColNum() + 1);
                    state = 4;
                }
                break;
            case 4:
                if (checkForValidTransform(Map.of("thirdPiece", Arrays.asList(pieceThree.getRowNum() + 1 , pieceThree.getColNum() + 1)))
                        && middlePieceInBounds()) {
                    transformFirstTwoPiece();
                    pieceThree.setRowNum(pieceThree.getRowNum() + 1);
                    pieceThree.setColNum(pieceThree.getColNum() + 1);
                    state = 1;
                }
                break;
        }
    }
}


