/**
 * Created by Hakim on 9/8/15.
 * Find whether two Strings are less than one edit away
 */
public class Solution05 {
    public static void main(String[] args){
        Solution05 oa = new Solution05();
        System.out.println(oa.isOneAway("pale","ple"));
        System.out.println(oa.isOneAway("pales","pale"));
        System.out.println(oa.isOneAway("pale","bale"));
        System.out.println(oa.isOneAway("pale","bake"));
        System.out.println(oa.isOneAway("",""));
        System.out.println(oa.isOneAway("","e"));
    }

    /**
     * Check whether two Strings are at most one edit away.
     * Possible edits are  insertion, deletion, and replacement
     * @param s - First input String
     * @param t - Second input String
     * @return true if s and t are less than one edit away. False otherwise
     */
    public boolean isOneAway(String s, String t){
        // If s and t's lengths are different by more than 1, then return false
        if (Math.abs(s.length()-t.length()) > 1){
            return false;
        }
        // Make sure the first input String is greater or equal than the second one
        if (s.length() < t.length()){
            return isOneAway(t,s);
        }

        int i = 0;  // Pointer for the first String
        int j = 0;  // Pointer for the second String

        int diff = 0;   // Count the number of differences (edits) between the two Strings
        while (i < s.length() && j < t.length()){
            // If two characters are different, increment count
            if (s.charAt(i) != t.charAt(j)){
                diff++;
                if (s.length() != t.length()){
                    // If s and t have different sizes, than edit should be a deletion
                    i++;
                    continue;
                }
            }
            i++;
            j++;
        }

        if (diff <= 1){
            return true;
        }
        else{
            return false;
        }
    }
}
