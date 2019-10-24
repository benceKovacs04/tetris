package com.codecool.tetromino;

import java.util.Set;

public interface Stashable {
    Set<ActivePiece> getPieces();
    void setDefaultPosition();
}
