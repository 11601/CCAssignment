/**
 * Created by Hakim on 10/13/15.
 */
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        solution12.printAllArrangements(8);
    }

    /**
     * Print all possible ways of arranging N queens on an NxN board so that none
     * of them share the same row, column, or diagonal.
     * @param N
     */
    public void printAllArrangements(int N){
        Integer[] columns = new Integer[N];
        printAllArrangements(columns, 0, N);
    }

    /**
     * Helper function to printAllArrangements.
     * @param columns
     * @param index
     * @param N
     */
    public void printAllArrangements(Integer[] columns, int index, int N) {
        if (index == N) {   // found an arrangement, print it
            printBoardTranspose(columns, N);
            System.out.println();
        }
        else {
            for (int row=0; row<N; row++){
                // test all the ways to place a queen in column index.
                Integer[] temp = columns.clone();
                if (isValidArrangement(temp, row, index, N)){
                    // keep this arrangement if it is valid
                    temp[index] = row;
                    printAllArrangements(temp, index+1, N);
                }
            }
        }
    }

    /**
     * Check whether it is possible to add a queen in row row and column col
     * given the placements on the previous columns.
     * @param columns
     * @param row
     * @param col
     * @return
     */
    public boolean isValidArrangement(Integer[] columns, int row, int col, int N){
        // Check row
        for (int c=0; c<col; c++){
            if (columns[c] == row){
                return false;
            }
        }

        // Don't need to check the column as we are adding one queen per column

        // Check the diagonals
        // Check the upper left diagonal
        int i=1;
        while (row-i>=0 && col-i>=0){
            if (columns[col-i] == row-i){
                return false;
            }
            i++;
        }

        // Check the lower left diagonal
        int j=1;
        while (row+j<N && col-j>=0){
            if (columns[col-j] == row+j){
                return false;
            }
            j++;
        }

        return true;    // all good
    }

    /**
     * Print the arrangement of the board defined by columns.
     * @param columns
     * @param N
     */
    public void printBoardTranspose(Integer[] columns, int N) {
        // print the transpose of the board. Fine since all combinations will be printed
        // => all transposes = all originals
        for (int c : columns){
            printColumnTranspose(c, N);
            System.out.println();
        }
    }

    /**
     * Print the transpose of the column that contains a queen on row c.
     * @param c
     * @param N
     */
    public void printColumnTranspose(int c, int N) {
        for (int i=0; i<c; i++) {
            System.out.print("* ");
        }
        System.out.print("Q ");
        for (int i=c+1; i<N; i++){
            System.out.print("* ");
        }
    }
}
