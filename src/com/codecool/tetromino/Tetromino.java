package com.codecool.tetromino;


import com.codecool.tetris.TetrominoSetter;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public abstract class Tetromino {

    TetrominoPiece pieceOne = new TetrominoPiece();
    TetrominoPiece pieceTwo = new TetrominoPiece();
    TetrominoPiece pieceThree = new TetrominoPiece();
    TetrominoPiece pieceFour = new TetrominoPiece();

    private TetrominoSetter game;

    public Tetromino(TetrominoSetter game) {
        this.game = game;
    }

    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                TetrominoPiece leftPiece = Collections.min(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (leftPiece.getColNum() > 0) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() - 1);
                    }
                }
                break;
            case RIGHT:
                TetrominoPiece rightPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (rightPiece.getColNum() < 9) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() + 1);
                    }
                }
                break;
            case DOWN:
                TetrominoPiece lowestPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getRowNum()));
                if (lowestPiece.getRowNum() < 21) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                } else {
                    game.spawnNewActiveTetromino();
                }
        }
    }

    public abstract void transform();

    public Set<TetrominoPiece> getPieces() {
        Set<TetrominoPiece> pieces = new HashSet<>();
        pieces.add(pieceOne);
        pieces.add(pieceTwo);
        pieces.add(pieceThree);
        pieces.add(pieceFour);

        return pieces;
    }

}
