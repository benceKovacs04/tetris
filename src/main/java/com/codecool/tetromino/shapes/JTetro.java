package com.codecool.tetromino.shapes;

import com.codecool.tetris.TetrominoHandler;
import com.codecool.tetromino.CenterPieceTetromino;
import com.codecool.tetromino.ActivePiece;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JTetro extends CenterPieceTetromino {

    public JTetro(TetrominoHandler game) {
        super(game);

        PONE_COL = 4;
        PONE_ROW = 0;

        PTWO_COL = 4;
        PTWO_ROW = 1;

        PTHREE_COL = 6;
        PTHREE_ROW = 1;

        PFOUR_COL = 5;
        PFOUR_ROW = 1;

        setDefaultPosition();

        pieceOne.setSpecialGridColNum(1);
        pieceOne.setSpecialGridRowNum(2);

        pieceTwo.setSpecialGridColNum(1);
        pieceTwo.setSpecialGridRowNum(3);

        pieceThree.setSpecialGridColNum(3);
        pieceThree.setSpecialGridRowNum(3);

        pieceFour.setSpecialGridColNum(2);
        pieceFour.setSpecialGridRowNum(3);

        pieceOne.setFill(Color.BLUE);
        pieceTwo.setFill(Color.BLUE);
        pieceThree.setFill(Color.BLUE);
        pieceFour.setFill(Color.BLUE);
    }

    @Override
    protected Map<ActivePiece, List<Integer>> getStateOneTransformationMap() {
        Map<ActivePiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum(), pieceOne.getColNum() + 2),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() + 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<ActivePiece, List<Integer>> getStateTwoTransformationMap() {
        Map<ActivePiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() + 2, pieceOne.getColNum()),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() + 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() - 1)
        ));

        return nextState;
    }

    @Override
    protected Map<ActivePiece, List<Integer>> getStateThreeTransformationMap() {
        Map<ActivePiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum(), pieceOne.getColNum() - 2),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() + 1, pieceTwo.getColNum() - 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() - 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }

    @Override
    protected Map<ActivePiece, List<Integer>> getStateFourTransformationMap() {
        Map<ActivePiece, List<Integer>> nextState = new HashMap<>(Map.of(
                pieceOne, Arrays.asList(pieceOne.getRowNum() -2, pieceOne.getColNum()),
                pieceTwo, Arrays.asList(pieceTwo.getRowNum() - 1, pieceTwo.getColNum() - 1),
                pieceThree, Arrays.asList(pieceThree.getRowNum() + 1, pieceThree.getColNum() + 1)
        ));

        return nextState;
    }

}
