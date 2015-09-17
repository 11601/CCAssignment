
//Problem: Write a method to replace all spaces in a string with '%20'.  You may assume
//the string has sufficient space at the end to hold the additional characters, and that
//you are given the "true" length of the string.
//Use a character array so you can perform the operation in place.

//Logic: for every space contained in the argument string, shift the next element over two places,
//and insert '%20' in the 3 blank spaces.

public class Solution03 {

	public static String replaceSpaces(String s){
		
		if(s == null) return null;
		
		//trueLength is the length of s *without* the extra spaces at the end
		int trueLength = s.length();
		
		int spaceCount = 0;
		
		//We must get a count of spaces so as to know how long to make the char array
		for(int i=trueLength-1; i>=0; i--){
			if(s.charAt(i) == ' '){
				spaceCount++;
			}
		}
		
		//If we find no spaces, simply return the given string
		if(spaceCount == 0) return s;
		
		//We initialize sChars with two extra indexes for every space in s
		char[] sChars = new char[trueLength + 2*spaceCount];
		
		//Create a variable to hold the difference in size between the "true" length of s
		//and the length of the char array that contains the extra spaces.
		//We use this variable to create and compute the variable sCharsIndex,
		//which we'll use to keep track of where we are in the sChars array
		int diff = 2*spaceCount;
		int sCharsIndex = trueLength + diff - 1;
		
		//We iterate through s and sChars in reverse, so that we can take advantage of the
		//empty space at the end of sChars and don't have to continually use temporary
		//variable and costly array shifting operations:
		for(int i=trueLength-1; i>=0; i--){
			
			//If we find a space in s, we copy over the chars of '%20' into the the sChars array
			//and decrement sCharsIndex by 3 to keep track of our true index
			if(s.charAt(i) == ' '){
				sChars[sCharsIndex] = '0';
				sChars[sCharsIndex - 1] = '2';
				sChars[sCharsIndex - 2] = '%';
				
				sCharsIndex = sCharsIndex - 3; 
				
			//Otherwise, we simply at the char at position i of s into the sChars array,
			//and decrement sCharsIndex by one to keep track of our true index
			} else {
				sChars[sCharsIndex] = s.charAt(i);
				
				sCharsIndex--;
			}
		}
		
		//Return the new string
		return new String(sChars);
		
	}
	
}
