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

