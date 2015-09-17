import java.util.Arrays;

//Problem: Given two strings, write a method to determine if one is a permutation of the other

public class Solution02 {

	public static boolean isPermutation(String x, String y){
		
		//check if either input string is null, and return false if so.
		if(x == null || y == null) return false;
		
		//We assume case matters (e.g. "God" is not a permutation of "dog")
		
		//First, we check if the strings are the same length.
		//If they're not, one cannot possibly be a permutation of the other.
		if(x.length() != y.length()) return false;
		
		//We create two char arrays, to store the individual characters of x and y, respectively, and populate them.
		char[] xChars = x.toCharArray();
		char[] yChars = y.toCharArray();
		
		//We sort each of our char arrays, so we can check if the elements line up.
		//We'll check this using a for loop.  If we find an index at which the elements
		//for xChars and yChars differ, we immediately return false.
		Arrays.sort(xChars);
		Arrays.sort(yChars);
		
		for(int i=0; i<xChars.length; i++){
			if(xChars[i] != yChars[i]){
				return false;
			}
		}
		//If we make it through the for loop without returning false, we know that
		//x is a permutation of y (and vice versa), so we return true;
		return true;
	}
	
}
