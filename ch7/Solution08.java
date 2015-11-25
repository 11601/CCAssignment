import java.util.Date;
import java.util.List;

/**
 * Created by Hakim on 10/26/15.
 */

class Player{
    private String name;
    private int id;
    private boolean color;  // black/white false/true
}

class GameController{
    private int numRows;
    private int numCols;
    private Date begin;
    private Date end;
    private Board board;
    private List<Player> players;
}

class Board{
    private int numRows;
    private int numCols;
    private boolean[][] board;  // true/false white/black
    private int totalWhite;
    private int totalBlack;
    public Board(int numRows, int numCols){}
    public boolean canStillPlay(){};
    public boolean isLegalPlacement(){};
    public void updateCounts(){};
    public void placePiece(int row, int col, boolean color){};
}

class Piece{
    private boolean currentColor;
    public void flipPiece(){};
    public void playPiece(int row, int col){}
}



public class Solution08 {
}
