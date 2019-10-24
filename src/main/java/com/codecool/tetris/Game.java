package com.codecool.tetris;

import com.codecool.tetromino.*;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;


public class Game extends GridPane implements GameTick, TetrominoHandler {

    public static final int COLNUMBER = 10;
    public static final int ROWNUMBER = 22;
    private GameTimer gameTimer;
    private TetrominoFactory tetrominoFactory = new TetrominoFactory(this);
    private GameLoop gameLoop;
    private Stash stash;
    private Queue queue;

    private int score = 0;

    private Tetromino activeTetromino;

    public Game(Stash stash, Queue queue) {
        this.queue = queue;
        queue.setTetrominoFactory(tetrominoFactory);
        this.stash = stash;
        this.getStyleClass().add("myGridStyle");
        this.getStylesheets().add("Main.css");

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

        this.setPadding(new Insets(30, 0,30,280));
    }

    public void init() {
        this.gameLoop = new GameLoop(this);
        this.gameTimer = new GameTimer(gameLoop::step);
        gameTimer.startDefault();
        gameLoop.start();
    }


    @Override
    public void spawnNewActiveTetromino() {
        Tetromino nextTetro = queue.getInQueueTetromino();
        queue.setNewInQueueTetromino();
        if (nextTetro.canSpawn()) {
            this.activeTetromino = nextTetro;
        } else {
            gameLoop.stop();
        }
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

    @Override
    public void moveTetromino(Actions dir) {
        if (gameLoop.isRunning()) {
            switch (dir) {
                case LEFT:
                    activeTetromino.move(Actions.LEFT);
                    drawActiveAndShadowPieces();
                    break;
                case RIGHT:
                    activeTetromino.move(Actions.RIGHT);
                    drawActiveAndShadowPieces();
                    break;
                case TRANSFORM:
                    activeTetromino.transform();
                    killShadow();
                    activeTetromino.handleShadow();
                    drawActiveAndShadowPieces();
                    break;
                case BOTTOM:
                    activeTetromino.move(Actions.BOTTOM);
                    drawActiveAndShadowPieces();
                    break;
                case STASH:
                    if(!activeTetromino.haveBeenStashed()) {
                        activeTetromino.stashIt();
                        stash.stashTetromino(activeTetromino);
                        if(stash.getStashedTetromino() != null) {
                            activeTetromino = (Tetromino) stash.getStashedTetromino();
                        } else {
                            spawnNewActiveTetromino();
                        }
                    }
                    drawActiveAndShadowPieces();
                    break;
            }
        }
    }

    public void drawActiveAndShadowPieces() {
        for (TetrominoPiece piece : activeTetromino.getPieces()) {
            this.getChildren().remove(piece);
            this.add(piece, piece.getColNum(), piece.getRowNum());
        }
        killShadow();
        for (TetrominoPiece piece : activeTetromino.getShadowPieces()) {
            this.add(piece, piece.getColNum(), piece.getRowNum());
        }
    }

    @Override
    public void killShadow() {
        for (TetrominoPiece shadowPiece : activeTetromino.getShadowPieces()) {
            if (getChildren().contains(shadowPiece)) {
                getChildren().remove(shadowPiece);
            }
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
        handleScore();
        movePiecesDown(currentRow);
        handleFullRows();
    }

    private void movePiecesDown(int fullRowNum) {
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

    private void handleScore() {
        score += 100;
        System.out.println(score);
        switch(score) {
            case 1000:
                gameTimer.updateSpeed(0.4);
                break;
            case 3000:
                gameTimer.updateSpeed(0.3);
                break;
            case 6000:
                gameTimer.updateSpeed(0.2);
                break;
            case 10000:
                gameTimer.updateSpeed(0.1);
        }
    }

    public void step() {
        activeTetromino.move(Actions.DOWN);
        drawActiveAndShadowPieces();
    }
}
