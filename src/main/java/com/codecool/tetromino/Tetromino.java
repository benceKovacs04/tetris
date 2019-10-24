package com.codecool.tetromino;


import com.codecool.tetris.TetrominoHandler;
import javafx.scene.Node;

import java.util.*;
import java.util.List;

import static com.codecool.tetromino.Actions.LEFT;
import static com.codecool.tetromino.Actions.RIGHT;

public abstract class Tetromino implements Stashable{

    protected int PONE_COL;
    protected int PONE_ROW;

    protected int PTWO_COL;
    protected int PTWO_ROW;

    protected int PTHREE_COL;
    protected int PTHREE_ROW;

    protected int PFOUR_COL;
    protected int PFOUR_ROW;

    protected int state = 1;

    protected final int COLNUMBER = 10;
    protected final int ROWNUMBER = 22;

    protected TetrominoPiece pieceOne = new TetrominoPiece();
    protected TetrominoPiece pieceTwo = new TetrominoPiece();
    protected TetrominoPiece pieceThree = new TetrominoPiece();
    protected TetrominoPiece pieceFour = new TetrominoPiece();

    protected TetrominoPiece shadowPieceOne = new TetrominoPiece();
    protected TetrominoPiece shadowPieceTwo = new TetrominoPiece();
    protected TetrominoPiece shadowPieceThree = new TetrominoPiece();
    protected TetrominoPiece shadowPieceFour = new TetrominoPiece();

    protected Set<TetrominoPiece> pieces = new HashSet<>(Arrays.asList(
            pieceOne,
            pieceTwo,
            pieceThree,
            pieceFour
    ));

    protected Set<TetrominoPiece> shadowPieces = new HashSet<>(Arrays.asList(
            shadowPieceOne,
            shadowPieceTwo,
            shadowPieceThree,
            shadowPieceFour
    ));

    protected TetrominoHandler game;

    private boolean wasStashed = false;

    public Tetromino(TetrominoHandler game) {
        this.game = game;
        pieces.add(pieceOne);
        pieces.add(pieceTwo);
        pieces.add(pieceThree);
        pieces.add(pieceFour);
    }

    public void move(Actions actions) {
        TetrominoPiece bottomPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getRowNum()));

        switch (actions) {
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
                if (bottomPiece.getRowNum() < 21 && checkBottomCollision(pieces)) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                } else {
                    game.handleFullRows();
                    game.spawnNewActiveTetromino();
                }
                break;
            case BOTTOM:
                while(checkBottomCollision(pieces) && bottomPiece.getRowNum() < 21) {
                    for (TetrominoPiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                }
                break;
        }
    }

    private boolean checkSideCollision(Actions dir) {
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

    private boolean checkBottomCollision(Set<TetrominoPiece> piecesToCheck) {
        Map<TetrominoPiece, List<Integer>> nextPos = new HashMap<>();

        for (TetrominoPiece piece : piecesToCheck) {
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

    @Override
    public Set<TetrominoPiece> getPieces() { return pieces; }

    public Set<TetrominoPiece> getShadowPieces() { return shadowPieces; }

    public boolean canSpawn() {
        return checkBottomCollision(pieces);
    }

    public boolean haveBeenStashed() {
        return wasStashed;
    }

    public void stashIt() {
        if (!wasStashed) {
            wasStashed = true;
        }
    }

    @Override
    public void setDefaultPosition() {

        state = 1;

        pieceOne.setColNum(PONE_COL);
        pieceOne.setRowNum(PONE_ROW);

        pieceTwo.setColNum(PTWO_COL);
        pieceTwo.setRowNum(PTWO_ROW);

        pieceThree.setColNum(PTHREE_COL);
        pieceThree.setRowNum(PTHREE_ROW);

        pieceFour.setColNum(PFOUR_COL);
        pieceFour.setRowNum(PFOUR_ROW);
    }
}
