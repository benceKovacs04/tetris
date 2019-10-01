package com.codecool.tetris;


import javafx.scene.Node;

import java.util.List;

public interface TetrominoHandler {
    void spawnNewActiveTetromino();
    Node getNodeByRowColumnIndex(int row, int column);
    void handleFullRows();
}
