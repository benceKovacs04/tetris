package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;

import java.util.List;
import java.util.Map;

public abstract class CenterPieceTetromino extends Tetromino {

    public CenterPieceTetromino(TetrominoHandler game) {
        super(game);
    }

    protected boolean middlePieceInBounds() {
        return pieceFour.getRowNum() < ROWNUMBER - 1 && pieceFour.getRowNum() > 0 &&
                pieceFour.getColNum() <= COLNUMBER - 2 && pieceFour.getColNum() > 0;
    }

    protected abstract Map<TetrominoPiece, List<Integer>> getStateOneTransformationMap();
    protected abstract Map<TetrominoPiece, List<Integer>> getStateTwoTransformationMap();
    protected abstract Map<TetrominoPiece, List<Integer>> getStateThreeTransformationMap();
    protected abstract Map<TetrominoPiece, List<Integer>> getStateFourTransformationMap();

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
