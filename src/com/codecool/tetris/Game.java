package com.codecool.tetris;

import com.codecool.tetromino.Direction;
import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoPiece;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.HashSet;
import java.util.Set;

public class Game extends GridPane implements Gameplay {

    private final int COLNUMBER = 10;
    private final int ROWNUMBER = 22;
    private GameTimer gameTimer = new GameTimer();

    private Tetromino activeTetromino;

    private Set<Tetromino> pieces = new HashSet<>();

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

    public void init() {
        GameLoop gameLoop = new GameLoop(this);
        gameTimer.setup(gameLoop::step);
        gameTimer.play();
    }

    public void setActiveTetromino(Tetromino tetromino) {
        this.activeTetromino = tetromino;
    }

    public void drawActivePiece() {
        for (TetrominoPiece piece : activeTetromino.getPieces()) {
            this.getChildren().remove(piece);
            this.add(piece, piece.getColNum(), piece.getRowNum());
        }
    }

    public void step() {
        activeTetromino.move(Direction.DOWN);
        drawActivePiece();
    }
}
