package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.CenterPieceTetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTetro extends CenterPieceTetromino {

    public LTetro(TetrominoHandler game) {
        super(game);

        PONE_COL = 4;
        PONE_ROW = 1;

        PTWO_COL = 6;
        PTWO_ROW = 0;

        PTHREE_COL = 6;
        PTHREE_ROW = 1;

        PFOUR_COL = 5;
        PFOUR_ROW = 1;

        setDefaultPosition();

        pieceOne.setSpecialGridColNum(2);
        pieceOne.setSpecialGridRowNum(3);

        pieceTwo.setSpecialGridColNum(4);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(4);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(3);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.ORANGE);
        pieceTwo.setFill(Color.ORANGE);
        pieceThree.setFill(Color.ORANGE);
        pieceFour.setFill(Color.ORANGE);
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 1, pieceOne.getColNum() + 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 2, pieceTwo.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 1, pieceOne.getColNum() + 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum() - 2),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateThreeTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 1, pieceOne.getColNum() - 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() -2, pieceTwo.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateFourTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 1, pieceOne.getColNum() - 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum() + 2),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }
}
