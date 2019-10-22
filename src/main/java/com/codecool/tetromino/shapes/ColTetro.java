package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.scene.paint.Color;

import java.util.*;

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

        pieceOne.setSpecialGridColNum(4);
        pieceOne.setSpecialGridRowNum(2);

        pieceTwo.setSpecialGridColNum(4);
        pieceTwo.setSpecialGridRowNum(3);

        pieceThree.setSpecialGridColNum(4);
        pieceThree.setSpecialGridRowNum(4);

        pieceFour.setSpecialGridColNum(4);
        pieceFour.setSpecialGridRowNum(5);

        pieceOne.setFill(Color.AQUA);
        pieceTwo.setFill(Color.AQUA);
        pieceThree.setFill(Color.AQUA);
        pieceFour.setFill(Color.AQUA);
    }

    private Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 2, pieceOne.getColNum() + 2),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() + 1),
                pieceFour, Arrays.asList(pieceFour.getRowNum() - 1, pieceFour.getColNum() - 1)));

        return nextState;
    }

    private Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 2, pieceOne.getColNum() - 2),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() - 1),
                pieceFour, Arrays.asList(pieceFour.getRowNum() + 1, pieceFour.getColNum() + 1)));

        return nextState;
    }

    @Override
    public void transform() {
        Map<TetrominoPiece, List<Integer>> nextState;
        switch (state) {
            case 1:
                nextState = getStateOneTransformationMap();
                if (pieceOne.getColNum() < COLNUMBER - 2 && pieceFour.getColNum() > 0 && checkForValidTransformation(nextState)) {
                    doTransformation(nextState);
                    state = 2;
                }
                break;
            case 2:
                nextState = getStateTwoTransformationMap();
                if (checkForValidTransformation(nextState)) {
                    doTransformation(nextState);
                    state = 1;
                }
                break;
        }
    }
}
