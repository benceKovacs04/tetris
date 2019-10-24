package com.codecool.tetromino;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TetrominoPiece extends Rectangle {

    private int rowNum;
    private int colNum;

    private int specialGridRowNum;
    private int specialGridColNum;

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

    public int getSpecialGridRowNum() {
        return specialGridRowNum;
    }

    public void setSpecialGridRowNum(int specialGridRowNum) {
        this.specialGridRowNum = specialGridRowNum;
    }

    public int getSpecialGridColNum() {
        return specialGridColNum;
    }

    public void setSpecialGridColNum(int specialGridColNum) {
        this.specialGridColNum = specialGridColNum;
    }

    public TetrominoPiece() {
        super(24, 24);
        this.setStroke(Color.LIGHTCYAN);
        this.setArcHeight(10);
        this.setArcWidth(10);
    }
}
