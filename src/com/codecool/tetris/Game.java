package com.codecool.tetris;

import com.codecool.tetromino.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static com.codecool.tetromino.Direction.LEFT;

public class Game extends GridPane implements GameTick, TetrominoHandler {

    public static final int COLNUMBER = 10;
    public static final int ROWNUMBER = 22;
    private GameTimer gameTimer = new GameTimer();
    private TetrominoFactory tetrominoFactory = new TetrominoFactory(this);

    public Tetromino activeTetromino;

    public Game() {
        //this.setGridLinesVisible(true);
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

        for (int i = 0; i < COLNUMBER; i++) {
            for (int j = 0; j < ROWNUMBER; j++) {
                Pane pane = new Pane();
                pane.getStyleClass().add("game-grid-cell");

                add(pane, i, j);
            }
        }

        this.setPadding(new Insets(30, 300,30,280));
    }

    public void init() {
        GameLoop gameLoop = new GameLoop(this);
        gameTimer.setup(gameLoop::step);
        gameTimer.play();
    }

    @Override
    public void spawnNewActiveTetromino() {
        this.activeTetromino = tetrominoFactory.getRandomTetromino();
    }

    @Override
    public Node getNodeByRowColumnIndex(int row, int column) {
        Node result = null;

        for (Node node : getChildren()) {
            if(!(node instanceof Group) && !(node instanceof Pane) && getRowIndex(node) == row && getColumnIndex(node) == column) {
                result = node;
                break;
           }
        }

        return result;
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
