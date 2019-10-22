package com.codecool.tetris;

import com.codecool.tetromino.Stashable;
import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class Stash extends GridPane{

    public static final int STASH_COL_NUM = 6;
    public static final int STASH_ROW_NUM = 6;

    private Stashable stashedTetromino = null;
    private Stashable previousStashedTetromino = null;
    private boolean alreadyUsed = false;

    public Stash() {
        this.getStylesheets().add("Main.css");
    }

    public void init() {
        for (int i = 0; i < STASH_COL_NUM; i++) {
            ColumnConstraints colConst = new ColumnConstraints(25);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < STASH_ROW_NUM; i++) {
            RowConstraints rowConst = new RowConstraints(25);
            this.getRowConstraints().add(rowConst);
        }

        for (int i = 0; i < STASH_COL_NUM; i++) {
            for (int j = 0; j < STASH_ROW_NUM; j++) {
                Pane pane = new Pane();
                pane.getStyleClass().add("game-grid-cell");

                this.add(pane, i, j);
            }
        }

        this.setPadding(new Insets(155, 0,30,280));
    }

    private void killChildren() {
        if (stashedTetromino != null) {
            for (TetrominoPiece piece : stashedTetromino.getPieces()) {
                getChildren().remove(piece);
            }
        }
    }

    public void stashTetromino(Tetromino tetro) {

        killChildren();
        previousStashedTetromino = stashedTetromino;
        stashedTetromino = tetro;

        for (TetrominoPiece piece : stashedTetromino.getPieces()) {
            this.add(piece, piece.getSpecialGridColNum(), piece.getSpecialGridRowNum());
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
