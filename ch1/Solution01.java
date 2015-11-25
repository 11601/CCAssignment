import java.util.List;

/**
 * Question 1.1
 * Created by hsidahme on 9/8/15.
 */
public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();

        String s1 = "asfgte";
        String s2 = "aasded";

        System.out.println("isUnique(" + s1 + "): " + solution01.isUnique(s1));
        System.out.println("isUnique(" + s2 + "): " + solution01.isUnique(s2));

        System.out.println("isUniqueV2(" + s1 + "): " + solution01.isUniqueV2(s1));
        System.out.println("isUniqueV2(" + s2 + "): " + solution01.isUniqueV2(s2));

    }

    /**
     * Determine if String s has all unique characters.
     * @param s - Input String
     * @return true if all the characters in s are unique. false otherwise
     */
    public boolean isUnique(String s){
        // Assume 8-bit ascii encoding (256 possible characters)
        if (s.length() > 256){
            return false;
        }

        // Create an array in which each element stores the count of the corresponding character
        int[] elements = new int[256];

        for (int i=0; i<s.length();i++){
            elements[s.charAt(i)]++;
        }

        for (int i=0; i<256; i++){
            if (elements[i] > 1){
                return false;
            }
        }

        // None of the characters is repeated, return true
        return true;
    }

    // Follow up: What if you cannot use additional data structures

    /**
     * Second version of isUnique that does not use any extra data structure.
     * @param s - Input String
     * @return true if s has unique characters only. false otherwise
     */
    public boolean isUniqueV2(String s){
        // O(n^2) complexity: For each character in s, check that none of the next characters is the same

        if (s == null || s.length() <= 1){
            return true;
        }

        for (int i=0; i<s.length()-1; i++){
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    return false;
                }
            }
        }

        // None of the characters is repeated, return true
        return true;
    }

}
