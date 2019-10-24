package com.codecool.tetromino;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ActivePiece extends TetrominoPiece {

    private int specialGridRowNum;
    private int specialGridColNum;

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

}
