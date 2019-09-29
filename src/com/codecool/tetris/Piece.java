package com.codecool.tetris;

public abstract class Piece {

    boolean moving = true;

    int boxOneCoord;
    int boxTwoCoord;
    int boxThreeCoord;
    int boxFourCoord;

    public abstract void move(Direction direction);

    public abstract void transform();

    public void stopPiece() {
        this.moving = false;
    }

}
