package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTetro extends CenterPieceTetromino {

    public LTetro(TetrominoHandler game) {
        super(game);

        pieceOne.setColNum(4);
        pieceOne.setRowNum(1);

        pieceTwo.setColNum(6);
        pieceTwo.setRowNum(0);

        pieceThree.setColNum(6);
        pieceThree.setRowNum(1);

        pieceFour.setColNum(5);
        pieceFour.setRowNum(1);


        pieceOne.setFill(Color.ORANGE);
        pieceTwo.setFill(Color.ORANGE);
        pieceThree.setFill(Color.ORANGE);
        pieceFour.setFill(Color.ORANGE);
    }

    private Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 1, pieceOne.getColNum() + 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 2, pieceTwo.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    private Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 1, pieceOne.getColNum() + 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum() - 2),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    private Map<TetrominoPiece, List<Integer>> getStateThreeTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 1, pieceOne.getColNum() - 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() -2, pieceTwo.getColNum()),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }

    private Map<TetrominoPiece, List<Integer>> getStateFourTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() - 1, pieceOne.getColNum() - 1),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum() + 2),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }


    @Override
    public void transform() {
        Map<TetrominoPiece, List<Integer>> nextState;
        switch (state) {
            case 1:
                nextState = getStateOneTransformationMap();
                if(middlePieceInBounds() && checkForValidTransformation(nextState)) {
                    doTransformation(nextState);
                    state = 2;
                }
                break;
            case 2:
                nextState = getStateTwoTransformationMap();
                if(middlePieceInBounds() && checkForValidTransformation(nextState)) {
                    doTransformation(nextState);
                    state = 3;
                }
                break;
            case 3:
                nextState = getStateThreeTransformationMap();
                if(middlePieceInBounds() && checkForValidTransformation(nextState)) {
                    doTransformation(nextState);
                    state = 4;
                }
                break;
            case 4:
                nextState = getStateFourTransformationMap();
                if(middlePieceInBounds() && checkForValidTransformation(nextState)) {
                    doTransformation(nextState);
                    state = 1;
                }
                break;
        }
    }


}
