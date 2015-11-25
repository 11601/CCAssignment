import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 10/9/15.
 */

/**
 * Coordinate class.
 */
class Coordinate{
    int row;
    int col;

    public Coordinate(int rowCoord, int colCoord){
        row = rowCoord;
        col = colCoord;
    }
}

/**
 * 8.2.
 */
public class Solution02 {
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();
        int numRows = 3;
        int numCols = 3;
        Coordinate upperRight = new Coordinate(0,2);
        Coordinate lowerLeft = new Coordinate(2, 0);

        List<Coordinate> forbidden = new ArrayList<>();
        forbidden.add(upperRight);
        forbidden.add(lowerLeft);

        List<Coordinate> path = solution02.findPath(numRows, numCols, forbidden);
        for (int i=0; i<path.size(); i++){
            System.out.println("(" + path.get(i).row + "," + path.get(i).col + ")");
        }
    }

    /**
     * Find a path from the upper left corner to the lower right one, avoiding forbidden cases.
     * @param numRows
     * @param numCols
     * @param forbidden
     * @return
     */
    public List<Coordinate> findPath(int numRows, int numCols, List<Coordinate> forbidden) {
        // Create the grid
        boolean[][] grid = new boolean[numRows][numCols];
        for (int i=0; i<numRows; i++){
            for (int j=0; j<numCols; j++){
                grid[i][j] = true;
            }
        }

        // mark the forbidden cases
        for (Coordinate c : forbidden){
            int row = c.row;
            int col = c.col;
            grid[row][col] = false;
        }

        // create memo to keep track of previously computed results
        boolean[][] memo = new boolean[numRows][numCols];
        memo[0][0] = true;  // path from start to itself

        // computed path. Empty array if none exists
        List<Coordinate> path = new ArrayList<>();
        Coordinate destination = new Coordinate(numRows-1, numCols-1);
        findPath(grid, memo, destination, path);

        return path;
    }

    /**
     * Helper function to find a path from upper left corner to lower right one, avoiding forbidden cases.
     * @param grid
     * @param memo
     * @param destination
     * @param path
     * @return
     */
    public boolean findPath(boolean[][] grid, boolean[][] memo, Coordinate destination, List<Coordinate> path) {
        if (destination.row < 0 || destination.row >= grid.length ||
                destination.col < 0 || destination.col >= grid[0].length ||
                !grid[destination.row][destination.col]){
            // out of bounds or forbidden
            return false;
        }
        if (memo[destination.row][destination.col]){    // already computed
            path.add(destination);
            return true;
        }

        Coordinate up = new Coordinate(destination.row-1, destination.col);
        Coordinate left = new Coordinate(destination.row, destination.col-1);
        if (findPath(grid, memo, up, path) || findPath(grid, memo, left, path)){
            path.add(destination);
            memo[destination.row][destination.col] = true;
        }

        return memo[destination.row][destination.col];
    }
}
