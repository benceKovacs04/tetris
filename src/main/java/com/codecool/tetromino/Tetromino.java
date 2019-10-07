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

    protected final int COLNUMBER = 10;
    protected final int ROWNUMBER = 22;

    protected TetrominoPiece pieceOne = new TetrominoPiece();
    protected TetrominoPiece pieceTwo = new TetrominoPiece();
    protected TetrominoPiece pieceThree = new TetrominoPiece();
    protected TetrominoPiece pieceFour = new TetrominoPiece();

    protected Set<TetrominoPiece> pieces = new HashSet<>();

    protected TetrominoHandler game;

    public Tetromino(TetrominoHandler game) {
        this.game = game;
        pieces.add(pieceOne);
        pieces.add(pieceTwo);
        pieces.add(pieceThree);
        pieces.add(pieceFour);
    }

    public void move(Direction direction) {
        TetrominoPiece bottomPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getRowNum()));
       /* if(direction == Direction.BOTTOM) {
            while(checkBottomCollision() && bottomPiece.getRowNum() < 21) {
                for (TetrominoPiece piece : getPieces()) {
                    piece.setRowNum(piece.getRowNum() + 1);
                }
            }
            return;
        }*/
        switch (direction) {
            case LEFT:
                TetrominoPiece leftPiece = Collections.min(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (leftPiece.getColNum() > 0 && checkSideCollision(LEFT)) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() - 1);
                    }
                }
                break;
            case RIGHT:
                TetrominoPiece rightPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (rightPiece.getColNum() < 9 && checkSideCollision(RIGHT)) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() + 1);
                    }
                }
                break;
            case DOWN:
                if (bottomPiece.getRowNum() < 21 && checkBottomCollision()) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                } else {
                    game.handleFullRows();
                    game.spawnNewActiveTetromino();
                }
                break;
            case BOTTOM:
                while(checkBottomCollision() && bottomPiece.getRowNum() < 21) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                }
                break;
        }
    }

    private boolean checkSideCollision(Direction dir) {
        Map<TetrominoPiece, List<Integer>> nextPos = new HashMap<>();
        switch (dir) {
            case LEFT:
                for (TetrominoPiece piece : pieces) {
                    nextPos.put(piece, Arrays.asList(piece.getRowNum(), piece.getColNum() - 1));
                }
                break;
            case RIGHT:
                for (TetrominoPiece piece : pieces) {
                    nextPos.put(piece, Arrays.asList(piece.getRowNum(), piece.getColNum() + 1));
                }
                break;
        }
        return checkForValidTransformation(nextPos);
    }

    private boolean checkBottomCollision() {
        Map<TetrominoPiece, List<Integer>> nextPos = new HashMap<>();

        for (TetrominoPiece piece : pieces) {
            nextPos.put(piece, Arrays.asList(piece.getRowNum() + 1, piece.getColNum()));
        }

        return checkForValidTransformation(nextPos);
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

    public int getLowestPieceRowNum() {
       TetrominoPiece lowestPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getRowNum()));
       return lowestPiece.getRowNum();
    }
}
