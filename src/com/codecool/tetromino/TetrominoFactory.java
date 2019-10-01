package com.codecool.tetromino;

import com.codecool.tetris.TetrominoHandler;

import java.util.Random;

public class TetrominoFactory {

    private TetrominoHandler game;

    private Random rnd;
    private int rndNum;

    public TetrominoFactory(TetrominoHandler game) {
        this.game = game;
        rnd = new Random();
    }

    public Tetromino getRandomTetromino() {
        rndNum = rnd.nextInt(7);
        switch(rndNum) {
            case 0:
                //return new BoxTetro(game);
                return new JTetro(game);
            case 1:
                return new JTetro(game);
            case 2:
                //return new JTetro(game);
                return new JTetro(game);
            case 3:
                //return new LTetro(game);
                return new JTetro(game);
            case 4:
                //return new STetro(game);
                return new JTetro(game);
            case 5:
                //return new TTetro(game);
                return new JTetro(game);
            case 6:
                //return new ZTetro(game);
                return new JTetro(game);
        }
        return null;
    }


}
