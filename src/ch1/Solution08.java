
//Problem: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column
//are set to zero


public class Solution08 {

	public static void setZeroes(int[][] matrix){
		
		//create two boolean arrays to store rows and columns, respectively, in which we find a zero in the matrix
		boolean[] rowFlags = new boolean[matrix.length];
		boolean[] colFlags = new boolean[matrix[0].length];
		
		//Iterate through the matrix and, when a zero is found, mark it in the rowFlags and colFlags arrays
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == 0){
					rowFlags[i] = true;
					colFlags[j] = true;
				}
			}
		}
		
		//Finally, call the two helper flags to set the proper rows and columns in matrix to zeroes,
		//based on our updated rowFlags and colFlags array
		setZeroRows(matrix, rowFlags);
		setZeroColumns(matrix, colFlags);
	}
	
	//This is a helper method that sets the rows in the matrix to zero that had been flagged as having a zero
	public static void setZeroRows(int[][] m, boolean[] r){
		
		for(int i=0; i<r.length; i++){
			if(r[i] == true){
				for(int j=0; j<m[0].length; j++){
					m[i][j] = 0;
				}
			}
		}
	}
	
	//This is a helper method that sets the columns in the matrix to zero that had been flagged as having a zero
	public static void setZeroColumns(int[][] m, boolean[] c){
		for(int i=0; i<c.length; i++){
			if(c[i] == true){
				for(int j=0; j<m.length; j++){
					m[j][i] = 0;
				}
			}
		}
	}
