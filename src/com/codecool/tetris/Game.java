package com.codecool.tetris;

import com.codecool.tetromino.*;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Game extends GridPane implements GameTick, TetrominoHandler {

    public static final int COLNUMBER = 10;
    public static final int ROWNUMBER = 22;
    private GameTimer gameTimer = new GameTimer();
    private TetrominoFactory tetrominoFactory = new TetrominoFactory(this);

    public Tetromino activeTetromino;

    public Game() {
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

    @Override
    public void handleFullRows() {
        List<Node> row = new ArrayList<>();
        for (int i = ROWNUMBER -1; i >= 0; i--) {
            for (int y = 0; y < COLNUMBER; y++) {
                row.add(getNodeByRowColumnIndex(i, y));
            }
            deleteRowIfFull(row, i);
            row.clear();
        }
    }

    private void deleteRowIfFull(List<Node> row, int currentRow) {
        for (Node node : row) {
            if (node == null) {
                return;
            }
        }


        for (Node node : row) {
            getChildren().remove(node);
        }

        movePiecesDown(currentRow);
        handleFullRows();
    }

    private void movePiecesDown(int fullRowNum) {
        //int lowestActivePieceRowNum = activeTetromino.getLowestPieceRowNum();
        for (int i = fullRowNum - 1; i > 0; i--) {
            for (int y = 0; y < COLNUMBER; y++) {
                Node piece = getNodeByRowColumnIndex(i, y);
                if (piece != null) {
                    int colIndex = getColumnIndex(piece);
                    int rowIndex = getRowIndex(piece);
                    getChildren().remove(piece);
                    add(piece, colIndex, rowIndex + 1);
                }
            }
        }
    }

    public void step() {
        activeTetromino.move(Direction.DOWN);
        drawActivePiece();
    }
}
