package com.codecool.tetris;


import com.codecool.tetromino.Direction;
import javafx.scene.Node;

import java.util.List;

public interface TetrominoHandler {
    void spawnNewActiveTetromino();
    Node getNodeByRowColumnIndex(int row, int column);
    void handleFullRows();
    void moveTetromino(Direction dir);
}
