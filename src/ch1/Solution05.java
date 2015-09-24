
//Problem: There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character.  Given two strings, write a function to check if
//they are one edit (or zero edits) away.


public class Solution05 {

	//We assume case matters (i.e. 'a' is not equal to 'A')
	
	public static boolean oneEditAway(String x, String y){
		
		//check if either of the input strings are null, and if so, return false
		if(x == null || y == null) return false;
		
		int xLength = x.length();
		int yLength = y.length();
		
		//if the lengths of x and y differ by more than one, they differ by more than one edit
		if(Math.abs(xLength - yLength) > 1) return false;
		
		//If x and y are the same length, we call a helper method, 'sameLength', that checks
		//whether they differ at more than one index (and if so, returns false; otherwise,
		//it returns true)
		if(xLength == yLength) return sameLength(x,y);
		
		//Assign the input strings to new String variables, to tell which is longer or shorter
		String longer = xLength > yLength ? x : y;
		String shorter = xLength <= yLength ? x : y;
		
		//Iterate through the two input strings; if we hit an index at which their chars don't match,
		//We call 'diffLength', which checks if the mismatch at this index is due to a single insertion,
		//deletion, or replacement, or if it is due to more than one of these
		return diffLength(longer, shorter);
		
	}
	
	//This 'diffLength' method will be called when one of the input strings is longer than the other
	//(by one).
	public static boolean diffLength(String l, String s){
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) != l.charAt(i)){
				return diffLengthHelper(l, s, i);
			}
		}
		return true;
	}
	
	//This 'diffLengthHelper' method is called when the 'diffLength' method (above) encounters
	//and index at which the two strings differ.  This method continues on to check if this is the
	//result of a single insertion / deletion (in which case it returns true), or if there are more
	//insertion deletions down the line (in which case it returns false)
	public static boolean diffLengthHelper(String l, String s, int diffIndex){
		for(int i=diffIndex; i<s.length(); i++){
			if(s.charAt(i) != l.charAt(i+1)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean sameLength(String a, String b){
		
		int numDiffs = 0;
		
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				numDiffs++;
			}
			if(numDiffs > 1){
				return false;
			}
		}
		return true;
	}
}
