package com.codecool.tetris;

import com.codecool.tetromino.Tetromino;
import com.codecool.tetromino.TetrominoFactory;
import javafx.geometry.Insets;

public class Queue extends SpecialGrid {

    private TetrominoFactory tetrominoFactory;

    private Tetromino inQueueTetromino;

    public Queue() {
        inQueueTetromino = tetrominoFactory.getRandomTetromino();
        this.setPadding(new Insets(155, 280,30,0));
        setGridLinesVisible(true);
    }

    public void setTetrominoFactory(TetrominoFactory tetrominoFactory) {
        this.tetrominoFactory = tetrominoFactory;
    }

    @Override
    protected void killChildren() {

    }
}
