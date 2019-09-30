package com.codecool.tetromino;


import com.codecool.tetris.TetrominoHandler;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static com.codecool.tetromino.Direction.LEFT;
import static com.codecool.tetromino.Direction.RIGHT;

public abstract class Tetromino {

    final int COLNUMBER = 10;
    final int ROWNUMBER = 22;

    TetrominoPiece pieceOne = new TetrominoPiece();
    TetrominoPiece pieceTwo = new TetrominoPiece();
    TetrominoPiece pieceThree = new TetrominoPiece();
    TetrominoPiece pieceFour = new TetrominoPiece();

    Set<TetrominoPiece> pieces = new HashSet<>();

    private TetrominoHandler game;

    public Tetromino(TetrominoHandler game) {
        this.game = game;
        pieces.add(pieceOne);
        pieces.add(pieceTwo);
        pieces.add(pieceThree);
        pieces.add(pieceFour);
    }

    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                TetrominoPiece leftPiece = Collections.min(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (leftPiece.getColNum() > 0 && !checkSideCollision(LEFT, leftPiece)) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() - 1);
                    }
                }
                break;
            case RIGHT:
                TetrominoPiece rightPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (rightPiece.getColNum() < 9 && !checkSideCollision(RIGHT, rightPiece)) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() + 1);
                    }
                }
                break;
            case DOWN:
                TetrominoPiece bottomPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getRowNum()));
                if (bottomPiece.getRowNum() < 21 && !checkBottomCollision(bottomPiece)) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                } else {
                    game.spawnNewActiveTetromino();
                }
        }
    }

    private boolean checkSideCollision(Direction dir, TetrominoPiece edgePiece) {
        int colToCheck = (dir == LEFT) ? edgePiece.getColNum() -1 : edgePiece.getColNum() + 1;

        for (TetrominoPiece piece : getPieces()) {
            if (piece.getColNum() == edgePiece.getColNum()) {
                if (game.getNodeByRowColumnIndex(piece.getRowNum(), colToCheck) != null) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkBottomCollision(TetrominoPiece bottomPiece) {
        int rowToCheck = bottomPiece.getRowNum() + 1;

        for (TetrominoPiece piece : getPieces()) {
            if (piece.getRowNum() == bottomPiece.getRowNum()) {
                if (game.getNodeByRowColumnIndex(rowToCheck, piece.getColNum()) != null) {
                    return true;
                }
            }
        }

        return false;
    }



    public abstract void transform();

    public Set<TetrominoPiece> getPieces() { return pieces; }

}
