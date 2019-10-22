package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.CenterPieceTetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZTetro extends CenterPieceTetromino {

    public ZTetro(TetrominoHandler game) {
        super(game);

        PONE_COL = 4;
        PONE_ROW = 0;

        PTWO_COL = 5;
        PTWO_ROW = 0;

        PTHREE_COL = 6;
        PTHREE_ROW = 1;

        PFOUR_COL = 5;
        PFOUR_ROW = 1;

        setDefaultPosition();

        pieceOne.setSpecialGridColNum(2);
        pieceOne.setSpecialGridRowNum(2);

        pieceTwo.setSpecialGridColNum(3);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(4);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(3);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.RED);
        pieceTwo.setFill(Color.RED);
        pieceThree.setFill(Color.RED);
        pieceFour.setFill(Color.RED);
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum(), pieceOne.getColNum() + 2),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() + 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1 , pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 2, pieceOne.getColNum()),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() - 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateThreeTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum(), pieceOne.getColNum() - 2),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() - 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateFourTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 2, pieceOne.getColNum()),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() + 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }
}
