package com.codecool.tetromino;

import java.util.Set;

public interface Stashable {
    Set<TetrominoPiece> getPieces();
    void setDefaultPosition();
}
