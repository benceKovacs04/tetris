package com.codecool.tetris;

import com.codecool.tetromino.Stashable;
import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.geometry.Insets;

public class Stash extends SpecialGrid{

    private Stashable stashedTetromino = null;
    private Stashable previousStashedTetromino = null;
    private boolean alreadyUsed = false;


    public Stash() {
        this.setPadding(new Insets(30, 0,30,560));

    }

    public void stashTetromino(Tetromino tetro) {
        killChildren();
        previousStashedTetromino = stashedTetromino;
        stashedTetromino = tetro;

        for (TetrominoPiece piece : stashedTetromino.getPieces()) {
            this.add(piece, piece.getSpecialGridColNum(), piece.getSpecialGridRowNum());
        }
    }

    @Override
    protected void killChildren() {
        if (stashedTetromino != null) {
            for (TetrominoPiece piece : stashedTetromino.getPieces()) {
                getChildren().remove(piece);
            }
        }
    }

    public Stashable getStashedTetromino() {
        if (!alreadyUsed) {
            alreadyUsed = true;
            return null;
        } else {
            previousStashedTetromino.setDefaultPosition();
            return previousStashedTetromino;
        }
    }
}
