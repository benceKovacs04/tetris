package com.codecool.tetris;


import com.codecool.tetromino.Actions;
import javafx.scene.Node;

public interface TetrominoHandler {
    void spawnNewActiveTetromino();
    Node getNodeByRowColumnIndex(int row, int column);
    void handleFullRows();
    void moveTetromino(Actions dir);
    void killShadow();
}
