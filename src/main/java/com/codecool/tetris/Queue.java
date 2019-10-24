package com.codecool.tetris;

import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoFactory;
import com.codecool.tetromino.TetrominoPiece;
import javafx.geometry.Insets;

public class Queue extends SpecialGrid {

    private TetrominoFactory tetrominoFactory;

    private Tetromino inQueueTetromino;

    public Queue() {
        this.setPadding(new Insets(30, 0,30,100));
    }

    public void setTetrominoFactory(TetrominoFactory tetrominoFactory) {
        this.tetrominoFactory = tetrominoFactory;
        inQueueTetromino = tetrominoFactory.getRandomTetromino();
    }

    @Override
    protected void killChildren() {
        for (TetrominoPiece piece : inQueueTetromino.getPieces()) {
            getChildren().remove(piece);
        }
    }

    private void drawInQueueTetromino() {
        for (TetrominoPiece piece : inQueueTetromino.getPieces()) {
            this.add(piece, piece.getSpecialGridColNum(), piece.getSpecialGridRowNum());
        }
    }

    public Tetromino getInQueueTetromino() {
        return inQueueTetromino;
    }

    public void setNewInQueueTetromino() {
        killChildren();
        inQueueTetromino = tetrominoFactory.getRandomTetromino();
        drawInQueueTetromino();
    }
}
