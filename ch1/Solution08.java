/**
 * Created by Hakim on 9/12/15.
 */

/**
 * Given an MxN matrix, if an element in this matrix is equal to 0,
 * then set the corresponding row and column to 0.
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        int[][] matrix = new int[2][3];

        matrix[0][0] = 1;
        matrix[0][1] = 4;
        matrix[0][2] = 7;

        matrix[1][0] = 0;
        matrix[1][1] = 2;
        matrix[1][2] = 3;

        System.out.println("Matrix before zeroing: ");
        solution08.printMatrix(matrix);

        solution08.zeroMatrix(matrix);

        System.out.println("Matrix after zeroing: ");
        solution08.printMatrix(matrix);


    }

    /**
     * If a matrix element is zero, then set the entire corresponding row and column to zeros.
     * @param matrix
     */
    public void zeroMatrix(int[][] matrix) {
        // Check whether the first row contains a zero
        boolean firstRowZero = rowContainsZero(matrix, 0);

        // Check whether the first column contains a zero
        boolean firstColZero = columnContainsZero(matrix, 0);

        // Write all the rows and columns that contain zeros
        // in the first row and first column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows containing a 0 to 0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowToZero(matrix, i);
            }
        }

        // Set columns containing a 0 to 0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                setColumnToZero(matrix, j);
            }
        }

        // Set first row to 0 if it originally contained one
        if (firstRowZero) {
            setRowToZero(matrix, 0);
        }

        // Set first column to 0 if it originally contained one
        if (firstColZero) {
            setColumnToZero(matrix, 0);
        }
    }

    /**
     * Set a row to zeros.
     * @param matrix - matrix from which the row is to be set to zeros
     * @param row - row to be set to zeros
     */
    public void setRowToZero(int[][] matrix, int row){
        for (int j=0; j<matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    /**
     * Set a column to zeros.
     * @param matrix - matrix from which the column is to be set to zeros
     * @param col - column to be set to zeros
     */
    public void setColumnToZero(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    /**
     * Check whether a row contains a zero.
     * @param matrix - matrix being inspected
     * @param row - row being inspected
     * @return true if row contains a zero. false otherwise
     */
    public boolean rowContainsZero(int[][] matrix, int row){
        for (int j=0; j<matrix[0].length; j++){
            if (matrix[row][j] == 0){
                return true;
            }
        }

        return false;
    }

    /**
     * Check whether a column contains a zero.
     * @param matrix - matrix being inspected
     * @param col - column being inspected
     * @return true if col contains a zero. false otherwise
     */
    public boolean columnContainsZero(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == 0){
                return true;
            }
        }

        return false;
    }

    /**
     * Helper function to print a 2D array.
     * @param matrix - 2D array to be printed
     */
    public void printMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
