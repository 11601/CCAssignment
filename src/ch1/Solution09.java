
//Problem: Assume you have a method isSubstring which checks if one word is a substring of another.
//Given two strings, s1 and s2, write code to check is s2 is a rotation of s1,
//using only one call to isSubstring

//Strategy: concatenate string b with itself, and check if a is a substring of bb.

//NOTE: I have said in the README file with these solutions that I worked through
//the previous (fifth) edition of this book over the summer, and that I remembered
//the logic behind some of the solutions.  This is especially true with this problem:
//I remembered immediately that the way you find if string x is a substring of string y
//is by concatenating y with itself and checking if x is a substring.  I did NOT, however,
//look at the solutions in the back of the textbooks (either the fifth or sixth editions)
//while completing these problems.

public class Solution09 {

	public static boolean isRotation(String a, String b){
		
		//Check is either of the input strings are null, and if so, return false
		if(a == null || b == null) return false;
		
		//If the two input strings are of different lengths, they cannot be rotations of one another
		if(a.length() != b.length()){
			return false;
		}
		
		//Concatenate b with itself to create a new string, of which we will check whether a is a substring.
		//If a is a substring of bb, then a is a rotation of b (or vice versa).
		String bb = b + b;
		
		return isSubstring(a,bb);
	}
	
	//We can simply construct the isSubstring method, as shown below (even though the problem
	//states we may assume it is provided)
	public static boolean isSubstring(String x, String y){
		String yy = y+y;
		return yy.contains(x);
	}
	
}
