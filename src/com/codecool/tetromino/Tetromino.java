package com.codecool.tetromino;


import java.util.HashSet;
import java.util.Set;

public abstract class Tetromino {

    TetrominoPiece pieceOne = new TetrominoPiece();
    TetrominoPiece pieceTwo = new TetrominoPiece();
    TetrominoPiece pieceThree = new TetrominoPiece();
    TetrominoPiece pieceFour = new TetrominoPiece();

    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                for (TetrominoPiece piece : getPieces()) {
                    piece.setColNum(piece.getColNum() - 1);
                }
                break;
            case RIGHT:
                for (TetrominoPiece piece : getPieces()) {
                    piece.setColNum(piece.getColNum() + 1);
                }
                break;
            case DOWN:
                for (TetrominoPiece piece : getPieces()) {
                    piece.setColNum(piece.getRowNum() + 1);
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
