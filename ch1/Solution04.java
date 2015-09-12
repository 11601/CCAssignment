/**
 * Created by Hakim on 9/8/15.
 */

/**
 * Check whether a String is the permutation of a palindrome.
 */
public class Solution04 {
    public static void main(String[] args){
        Solution04 pp = new Solution04();
        System.out.println(pp.isPalindromePermutation("Tact Coa"));
    }

    /**
     *  Check whether a String is the permutation of a palindrome.
     * @param s
     * @return true if it is. false otherwise
     */
    public boolean isPalindromePermutation(String s){
        // A String is a palindrome permutation iif
        // it contains an even count for each character except at most
        // one character which can be odd
        if (s == null || s.length() == 0){
            return true;
        }

        // Lower case the String and remove white spaces
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        // Assume 8-bit ascii encoding
        boolean[] isOdd = new boolean[256];

        // For each character c in the input String, save whether it is
        // represented an odd number of times
        for (int i=0; i<s.length(); i++){
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }

        // Count the number of odd characters
        int numberOdds = 0;

        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]){
                numberOdds++;
            }
            // At most one character can have an odd count
            if (numberOdds > 1){
                return false;
            }
        }
        return true;
    }
}
