package com.codecool.tetris;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game extends GridPane {

    private final int COLNUMBER = 10;
    private final int ROWNUMBER = 22;

    private Set<Piece> pieces = new HashSet<>();

    public Game() {
        this.setGridLinesVisible(true);
        this.getStyleClass().add("myGridStyle");
        this.getStylesheets().add("assets/Main.css");

        for (int i = 0; i < COLNUMBER; i++) {
            ColumnConstraints colConst = new ColumnConstraints(25);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < ROWNUMBER; i++) {
            RowConstraints rowConst = new RowConstraints(25);
            this.getRowConstraints().add(rowConst);
        }

        this.setPadding(new Insets(30, 300,30,280));
    }

    public void drawPiece(Piece piece) {
        //TODO: write it
    }
}
