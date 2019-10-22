package com.codecool.tetris;

import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoFactory;
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

    }
}
