/**
 * Created by Hakim on 9/11/15.
 */

/**
 * Rotate 2D array.
 */
public class Solution07 {
    public static void main(String[] args){
        Solution07 rm = new Solution07();
        int[][] matrix = new int[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        System.out.println("Original Matrix");
        rm.printMatrix(matrix);

        rm.rotate(matrix);

        System.out.println("Rotated Matrix");
        rm.printMatrix(matrix);
    }

    /**
     * Rotate a 2D array by 90 degrees.
     * @param image - 2D array to be rotated
     */
    public void rotate(int[][] image){
        int n = image.length;
        for (int layer=0; layer<n/2; layer++){
            for (int topColOffset=0; topColOffset<n-layer-1; topColOffset++){
                // topColOffset<n-layer-1: -1 to avoid swapping "edge" elements that were already swapped
                swap(image, layer, topColOffset);
            }
       }
    }

    /**
     * Swap elements in a layer.
     * @param image - 2D array from which the elements will be swapped
     * @param layer - Layer from which the elements will be swapped
     * @param topColOffset - Offset of the element in the layer that will be swapped
     */
    public void swap(int[][] image, int layer, int topColOffset){
        int n = image.length;

        // save image[layer][layer+topColOffset]
        int elt = image[layer][layer+topColOffset];

        // Set top to left
        image[layer][layer+topColOffset] = image[n-1-layer-topColOffset][layer];

        // Set left to bottom
        image[n-1-layer-topColOffset][layer] = image[n-1-layer][n-1-layer-topColOffset];

        // Set bottom to right
        image[n-1-layer][n-1-layer-topColOffset] = image[layer+topColOffset][n-1-layer];

        // Set right to original top
        image[layer+topColOffset][n-1-layer] = elt;
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
