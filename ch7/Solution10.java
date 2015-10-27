/**
 * Created by Hakim on 10/27/15.
 */

class Board{
    private int numRows;
    private int numCols;
    private int originalNumBombs;
    private int remainingNumBombs;
    private Cell[][] cells;

    public void initialize(){

    }

    public void uncoverAll(){

    }
}

class Cell{
    private int row;
    private int column;
    private boolean isBomb;
    private boolean isBlank;
    private boolean isGuess;
    private int num;

    public Cell(int r, int c, boolean isB, boolean isG, int num){

    }

    public void click(){

    }

    public void markAsGuess(int number){

    }
}

class Player{
    private int id;
    private String name;
    private Boolean hasWon;

    public Player(){

    }

    public void playOneMove(int r, int c, boolean guess){

    }

    public void play(){
        // while
    }



}

class Result{
    private boolean hitBomb;

}

public class Solution10 {
}
