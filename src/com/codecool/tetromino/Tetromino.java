package com.codecool.tetromino;


import com.codecool.tetris.TetrominoHandler;
import javafx.scene.Node;

import java.awt.*;
import java.util.*;
import java.util.List;

import static com.codecool.tetromino.Direction.LEFT;
import static com.codecool.tetromino.Direction.RIGHT;

public abstract class Tetromino {

    protected int state = 1;

    final int COLNUMBER = 10;
    final int ROWNUMBER = 22;

    TetrominoPiece pieceOne = new TetrominoPiece();
    TetrominoPiece pieceTwo = new TetrominoPiece();
    TetrominoPiece pieceThree = new TetrominoPiece();
    TetrominoPiece pieceFour = new TetrominoPiece();

    Set<TetrominoPiece> pieces = new HashSet<>();

    TetrominoHandler game;

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

    protected boolean checkForValidTransformation(Map<TetrominoPiece, List<Integer>> nextPositions) {

        Set<Node> futurePositions = new HashSet<>();

        for (List<Integer> coordinates : nextPositions.values()) {
            futurePositions.add(game.getNodeByRowColumnIndex(coordinates.get(0), coordinates.get(1)));
        }
        for (Node node : futurePositions) {
            if (node != null && !getPieces().contains(node)) {
                return false;
            }
        }
        return true;
    }

    protected void doTransformation(Map<TetrominoPiece, List<Integer>> nextPositions) {
        for (Map.Entry<TetrominoPiece, List<Integer>> entry : nextPositions.entrySet()) {
            entry.getKey().setRowNum(entry.getValue().get(0));
            entry.getKey().setColNum(entry.getValue().get(1));
        }
    }

    public abstract void transform();

    public Set<TetrominoPiece> getPieces() { return pieces; }
}
