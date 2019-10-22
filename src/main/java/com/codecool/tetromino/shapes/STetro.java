package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.CenterPieceTetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STetro extends CenterPieceTetromino {

    public STetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(1);

        pieceTwo.setColNum(5);
        pieceTwo.setRowNum(0);

        pieceThree.setColNum(6);
        pieceThree.setRowNum(0);

        pieceFour.setColNum(5);
        pieceFour.setRowNum(1);

        pieceOne.setSpecialGridColNum(4);
        pieceOne.setSpecialGridRowNum(3);

        pieceTwo.setSpecialGridColNum(5);
        pieceTwo.setSpecialGridRowNum(2);

        pieceThree.setSpecialGridColNum(6);
        pieceThree.setSpecialGridRowNum(2);

        pieceFour.setSpecialGridColNum(5);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.GREEN);
        pieceTwo.setFill(Color.GREEN);
        pieceThree.setFill(Color.GREEN);
        pieceFour.setFill(Color.GREEN);
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 1, pieceOne.getColNum() + 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() + 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 2, pieceThree.getColNum())
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 1, pieceOne.getColNum() + 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() - 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum() - 2)
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateThreeTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 1, pieceOne.getColNum() - 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() - 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 2, pieceThree.getColNum())
        ));

        return nextState;
    }

    @Override
    protected Map<TetrominoPiece, List<Integer>> getStateFourTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 1, pieceOne.getColNum() - 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() + 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum() + 2)
        ));

        return nextState;
    }
}
