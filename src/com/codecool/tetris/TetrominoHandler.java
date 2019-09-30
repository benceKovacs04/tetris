package com.codecool.tetris;


import javafx.scene.Node;

public interface TetrominoHandler {
    void spawnNewActiveTetromino();
    Node getNodeByRowColumnIndex(int row, int column);

}
