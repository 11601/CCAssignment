
//Problem: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
//method to rotate the image by 90 degrees.  Can you do this in place?

//CODE NOT RETURNING THE CORRECT RESULT! See TestClass1_07 for the tests..

public class Solution07 {

	public static void rotate90(int[][] matrix){
		
		int n = matrix.length;
		
		for(int level=0; level < n/2; level++){
			for(int i=0; i < n-level-1; i++){
				
				//Save the top row (a specific element in the top row).
				int temp = matrix[level][n-level-i-1];
				
				//Move the left row to the top row.
				matrix[level][n-level-i-1] = matrix[i][level];
				
				//Move the bottom row to the left row.
				matrix[i][level] = matrix[n-level-1][i];
				
				//Move the right row to the bottom row.
				matrix[n-level-1][i] = matrix[n-level-i-1][n-level-1];
				
				//Move the old top row to the right row.
				matrix[n-level-i-1][n-level-1] = temp;
			}
		}
		
	}
	
}
