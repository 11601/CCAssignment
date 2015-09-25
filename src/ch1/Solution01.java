package ch1;

import java.util.HashSet;


public class Solution01 {

//Problem: Implement an algorithm to determine if a string has all unique characters.
//What is you cannot use additional data structures?
	
//Assumption: case is irrelevant (a == A), and only alphanumeric characters (a-z, 0-9) are permitted
	
	public static boolean allUnique(String s){
		
		//check if the input string is null
		if(s == null) return false;
		
		//Enforce the assumption case is irrelevant for this question
		s = s.toLowerCase();
		
		//If the string length is longer than 36 characters, it must contain a duplicate character
		//(because there are only 26 letters, a-z, and 10 numbers, 0-9)
		if(s.length() > 36) return false;
		
		//Initialize a HashSet to hold chars found in s
		HashSet<Character> chars = new HashSet<Character>();
		
		//We iterate through the characters in s, returning false if we find a duplicate,
		//Or adding the current char to the set if it is not a duplicate.
		for(int i=0; i<s.length(); i++){
			
			char current = s.charAt(i);
			
			if(chars.contains(current)){
				return false;
			} else {
				chars.add(current);
			}
		}
		//If we reach this point, we have fully iterated through s and found no duplicates. So we return true.
		return true;
	}
	
}
