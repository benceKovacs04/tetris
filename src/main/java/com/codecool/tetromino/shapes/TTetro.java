package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.CenterPieceTetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TTetro extends CenterPieceTetromino {

    public TTetro(TetrominoHandler game) {
        super(game);

        PONE_COL = 4;
        PONE_ROW = 1;

        PTWO_COL = 5;
        PTWO_ROW = 0;

        PTHREE_COL = 6;
        PTHREE_ROW = 1;

        PFOUR_COL = 5;
        PFOUR_ROW = 1;

        setDefaultPosition();

        pieceOne.setSpecialGridColNum(1);
        pieceOne.setSpecialGridRowNum(3);

        pieceTwo.setSpecialGridColNum(2);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(3);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(2);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.PURPLE);
        pieceTwo.setFill(Color.PURPLE);
        pieceThree.setFill(Color.PURPLE);
        pieceFour.setFill(Color.PURPLE);
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum()),
                pieceTwo, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum()),
                pieceTwo, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateThreeTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum()),
                pieceTwo, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateFourTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum()),
                pieceTwo, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }
}


