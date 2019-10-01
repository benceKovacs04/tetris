package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;
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

    private Map<TetrominoPiece, List<Integer>> getNextStateTransformationMap() {
        Map<TetrominoPiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceTwo.getRowNum(), pieceTwo.getColNum()),
                pieceTwo, Arrays.asList(pieceThree.getRowNum(), pieceThree.getColNum())));

        return nextState;
    }

    @Override
    public void transform() {
        Map<TetrominoPiece, List<Integer>> nextState = getNextStateTransformationMap();
        switch (state) {
            case 1:
                nextState.put(pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() - 1));
                if (checkForValidTransformation(nextState) && middlePieceInBounds()) {
                    doTransformation(nextState);
                    state = 2;
                }
                break;
            case 2:
                nextState.put(pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1));
                if (checkForValidTransformation(nextState) && middlePieceInBounds()) {
                    doTransformation(nextState);
                    state = 3;
                }
                break;
            case 3:
                nextState.put(pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() + 1));
                if (checkForValidTransformation(nextState) && middlePieceInBounds()) {
                    doTransformation(nextState);
                    state = 4;
                }
                break;
            case 4:
                nextState.put(pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() + 1));
                if (checkForValidTransformation(nextState) && middlePieceInBounds()) {
                    doTransformation(nextState);
                    state = 1;
                }
                break;
        }
    }
}


