package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.scene.paint.Color;

import java.util.*;

public class ColTetro extends Tetromino {

    public ColTetro(TetrominoHandler game) {
        super(game);

        PONE_COL = 4;
        PONE_ROW = 0;

        PTWO_COL = 4;
        PTWO_ROW = 1;

        PTHREE_COL = 4;
        PTHREE_ROW = 2;

        PFOUR_COL = 4;
        PFOUR_ROW = 3;

        setDefaultPosition();

        pieceOne.setSpecialGridColNum(2);
        pieceOne.setSpecialGridRowNum(1);

        pieceTwo.setSpecialGridColNum(2);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(2);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(2);
        pieceFour.setSpecialGridRowNum(4);

        pieceOne.setFill(Color.AQUA);
        pieceOne.setStroke(Color.LIGHTGREY);
        pieceTwo.setFill(Color.AQUA);
        pieceTwo.setStroke(Color.LIGHTGREY);
        pieceThree.setFill(Color.AQUA);
        pieceThree.setStroke(Color.LIGHTGREY);
        pieceFour.setFill(Color.AQUA);
        pieceFour.setStroke(Color.LIGHTGREY);
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
