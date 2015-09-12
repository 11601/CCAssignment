/**
 * Created by Hakim on 9/8/15.
 */

public class Solution02 {
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();

        String s1 = "qwerty";
        String s2 = "wrtqey";
        String s3 = "qwerta";

        System.out.println("isPermutation(" + s1 + "," + s2 + "): " + solution02.isPermutation(s1,s2));
        System.out.println("isPermutation(" + s1 + "," + s3 + "): " + solution02.isPermutation(s1,s3));
    }

    /**
     * Check whether Strings s and t are permutations of each other.
     * @param s
     * @param t
     * @return true if s and t are permutations of each other. false otherwise
     */
    public boolean isPermutation(String s, String t){
        // If the two Strings have different lengths, they cannot be permutations of each other
        if (s.length() != t.length()){
            return false;
        }

        // Assume the Strings are 8-bit ascii encoded
        int[] elements = new int[256];

        // Count the number of occurrences for each character in s and subtract the number of occurrences
        // of this character in t
        for (int i=0; i<s.length(); i++){
            elements[s.charAt(i)]++;
            elements[t.charAt(i)]--;
        }

        // If any element in the elements arrays is non zero, than its count is not the same in s and t
        for (int i=0; i<256; i++){
            if (elements[i] != 0){
                return false;
            }
        }

        // All characters have same counts in s and t. They are permutations of each other
        return true;
    }
}
