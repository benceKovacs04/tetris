package com.codecool.tetromino;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TetrominoPiece extends Rectangle {

    private int rowNum;
    private int colNum;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public TetrominoPiece() {
        super(24, 24);
        this.setStroke(Color.GREY);
        this.setArcHeight(10);
        this.setArcWidth(10);
    }
}
