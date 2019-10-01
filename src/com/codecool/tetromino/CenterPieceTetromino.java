package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;

public abstract class CenterPieceTetromino extends Tetromino {

    public CenterPieceTetromino(TetrominoHandler game) {
        super(game);
    }

    protected boolean middlePieceInBounds() {
        return pieceFour.getRowNum() < ROWNUMBER - 1 && pieceFour.getRowNum() > 0 &&
                pieceFour.getColNum() <= COLNUMBER - 2 && pieceFour.getColNum() > 0;
    }


}
