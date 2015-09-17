
//Problem: Implement a method to perform basic string compression using the counts of repeated characters.
//For example, the string aabcccccaaa would become a2b1c5a3.  If the compressed string would not become
//smaller than the original string, your method should return the original string.
//You can assume the string has only uppercase and lowercase letters (a-z).


public class Solution06 {

	public static String compressString(String s){
		
		if(s == null) return null;
		
		//If the length of the compressed string would not be shorter than the input string,
		//Simply return the input string
		if(s.length() <= compressionLength(s)) return s;
		
		StringBuffer sb = new StringBuffer();
		
		int counter = 1;
		
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) != s.charAt(i-1)){
				sb.append(s.charAt(i-1));
				sb.append(counter);
				counter = 1;
			} else {
				counter++;
			}
		}
		
		//We must remember to append the last char and its count (the for loop will miss it)
		sb.append(s.charAt(s.length()-1));
		sb.append(counter);
		
		return sb.toString();
	}
	
	//This is a helper method to calculate the length of the compressed string
	public static int compressionLength(String a){
		
		int newLength = 0;
		int counter = 1;
		
		for(int i=1; i<a.length(); i++){
			if(a.charAt(i) != a.charAt(i-1)){
				//add 1 for the space taken by the char, and one for the number (or more if the
				//number has more than 1 digit; we check this with 'counter / 10' below).
				//we reset the counter to 1;
				newLength += 1 + (1 + counter / 10);
				counter = 1;
			} else {
				counter++;
			}
			//System.out.println(newLength);
		}
		//need to make sure we get the last char
		return newLength + 1 + (1 + counter / 10);
	}
	
}
