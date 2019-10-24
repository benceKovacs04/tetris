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

    protected ActivePiece pieceOne = new ActivePiece();
    protected ActivePiece pieceTwo = new ActivePiece();
    protected ActivePiece pieceThree = new ActivePiece();
    protected ActivePiece pieceFour = new ActivePiece();

    protected ShadowPiece shadowPieceOne = new ShadowPiece();
    protected ShadowPiece shadowPieceTwo = new ShadowPiece();
    protected ShadowPiece shadowPieceThree = new ShadowPiece();
    protected ShadowPiece shadowPieceFour = new ShadowPiece();

    protected Set<ActivePiece> pieces = new HashSet<>(Arrays.asList(pieceOne, pieceTwo, pieceThree, pieceFour));

    protected Set<ShadowPiece> shadowPieces = new HashSet<>(Arrays.asList(shadowPieceOne, shadowPieceTwo, shadowPieceThree, shadowPieceFour));

    protected TetrominoHandler game;

    private boolean wasStashed = false;

    public Tetromino(TetrominoHandler game) {
        this.game = game;
    }

    public void move(Actions actions) {
        ActivePiece bottomPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getRowNum()));

        switch (actions) {
            case LEFT:
                ActivePiece leftPiece = Collections.min(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (leftPiece.getColNum() > 0 && checkSideCollision(LEFT)) {
                    for (ActivePiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() - 1);
                    }
                }
                break;
            case RIGHT:
                ActivePiece rightPiece = Collections.max(getPieces(), Comparator.comparing(p -> p.getColNum()));
                if (rightPiece.getColNum() < 9 && checkSideCollision(RIGHT)) {
                    for (ActivePiece piece : getPieces()) {
                        piece.setColNum(piece.getColNum() + 1);
                    }
                }
                break;
            case DOWN:
                if (bottomPiece.getRowNum() < 21 && checkBottomCollision()) {
                    for (ActivePiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                } else {
                    game.handleFullRows();
                    game.spawnNewActiveTetromino();
                }
                break;
            case BOTTOM:
                while(checkBottomCollision() && bottomPiece.getRowNum() < 21) {
                    for (ActivePiece piece : getPieces()) {
                        piece.setRowNum(piece.getRowNum() + 1);
                    }
                }
                break;
        }
    }

    private boolean checkSideCollision(Actions dir) {
        Map<ActivePiece, List<Integer>> nextPos = new HashMap<>();
        switch (dir) {
            case LEFT:
                for (ActivePiece piece : pieces) {
                    nextPos.put(piece, Arrays.asList(piece.getRowNum(), piece.getColNum() - 1));
                }
                break;
            case RIGHT:
                for (ActivePiece piece : pieces) {
                    nextPos.put(piece, Arrays.asList(piece.getRowNum(), piece.getColNum() + 1));
                }
                break;
        }
        return checkForValidTransformation(nextPos);
    }

    private boolean checkBottomCollision() {
        Map<ActivePiece, List<Integer>> nextPos = new HashMap<>();

        for (ActivePiece piece : pieces) {
            nextPos.put(piece, Arrays.asList(piece.getRowNum() + 1, piece.getColNum()));
        }

        return checkForValidTransformation(nextPos);
    }

    protected boolean checkForValidTransformation(Map<ActivePiece, List<Integer>> nextPositions) {

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

    protected void doTransformation(Map<ActivePiece, List<Integer>> nextPositions) {
        for (Map.Entry<ActivePiece, List<Integer>> entry : nextPositions.entrySet()) {
            entry.getKey().setRowNum(entry.getValue().get(0));
            entry.getKey().setColNum(entry.getValue().get(1));
        }
    }

    public abstract void transform();

    @Override
    public Set<ActivePiece> getPieces() { return pieces; }

    public Set<ShadowPiece> getShadowPieces() {
        return shadowPieces;
    }

    private void setDefaultShadow() {
        shadowPieceOne.setColNum(pieceOne.getColNum());
        shadowPieceOne.setRowNum(pieceOne.getRowNum());

        shadowPieceTwo.setColNum(pieceTwo.getColNum());
        shadowPieceTwo.setRowNum(pieceTwo.getRowNum());

        shadowPieceThree.setColNum(pieceThree.getColNum());
        shadowPieceThree.setRowNum(pieceThree.getRowNum());

        shadowPieceFour.setColNum(pieceFour.getColNum());
        shadowPieceFour.setRowNum(pieceFour.getRowNum());
    }

    public boolean canSpawn() {
        return checkBottomCollision();
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
