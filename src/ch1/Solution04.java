import java.util.HashMap;


//Problem: Given a string, write a function to check if it is a permutation of a palindrome.
//A palindrome is a word or phrase that is the same forwards and backwards.  A permutation is
//a rearrangement of letters.  The palindrome does not need to be limited to dictionary words.


public class Solution04 {

	//Well put the argument into a char array, and for every unique char, we'll check if there
	//is an even number of such chars in the argument string.  We can allow at most one instance
	//of a char with an odd number of occurrences, IF the length of the string is odd (otherwise,
	//if the length of the string is even, all chars must have even frequencies)
	
	//We assume case matters for alphabetical chars (i.e. 'a' and 'A' are not equal)
	
	public static boolean isPermOfPalindrome(String s){
		
		//check for the null case or the empty string
		if(s == null || s.length() == 0) return false;
		
		//Create a HashMap to hold unique chars in s as keys, and their frequencies as values
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++){
			
			char currentChar = s.charAt(i);
			
			//If the current char in s is not in charMap, add it, and list its frequency as 1
			if(!charMap.containsKey(s.charAt(i))){
				charMap.put(currentChar, 1);
			
			//Otherwise, increment the frequency in charMap for that char
			} else {
				int newVal = charMap.get(currentChar) + 1;
				charMap.put(currentChar, newVal);
			}
		}
		
		//Now, iterate through the charMap to see how many chars occur in s with odd frequencies.
		//If the length of s is odd, we can permit at most one char with an odd frequency.
		//If s is even, we can permit none.  We use a helper method, created below.
		
		return helperMethod(charMap, s.length());
	}
	
	//We create a helper method that takes our HashMap and the length of our string as inputs,
	//and iterates over the HashMap to determine whether the underlying string is a permutation
	//of a palindrome:
	public static boolean helperMethod(HashMap<Character,Integer> map, int stringLength){
		
		int oddFrequencyChars = 0;
		
		for(char key : map.keySet()) {
			if(map.get(key) % 2 != 0){
				oddFrequencyChars++;
			}
			//If we find more than one char in the string occurring with an odd frequency,
			//There's no possibility of the string in question being a permutation of a 
			//palindrome, and we return false immediately
			if(oddFrequencyChars > 1){
				return false;
			}
		}
		
		//If the length of the string in question is even, there can be no chars with odd frequencies.
		//If the length of the string in question is odd, there can be one char with an odd frequency.
		if(stringLength % 2 == 0){
			return (oddFrequencyChars == 0);
		} else {
			return (oddFrequencyChars == 1);
		}
		
	}
	
}
//DON
