package com.codecool.tetromino;


import java.util.HashSet;
import java.util.Set;

public abstract class Tetromino {

    boolean moving = true;

    TetrominoPiece pieceOne = new TetrominoPiece();
    TetrominoPiece pieceTwo = new TetrominoPiece();
    TetrominoPiece pieceThree = new TetrominoPiece();
    TetrominoPiece pieceFour = new TetrominoPiece();

    public abstract void move(Direction direction);

    public abstract void transform();

    public void stopPiece() {
        this.moving = false;
    }

    public Set<TetrominoPiece> getPieces() {
        Set<TetrominoPiece> pieces = new HashSet<>();
        pieces.add(pieceOne);
        pieces.add(pieceTwo);
        pieces.add(pieceThree);
        pieces.add(pieceFour);

        return pieces;
    }

}
