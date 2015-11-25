/**
 * Created by Hakim on 9/12/15.
 */

/**
 * Check whether a String is a rotation of another using only one call to
 * a isSubstring method.
 */
public class Solution09 {
    public static void main(String[] args){
        Solution09 sr = new Solution09();
        System.out.println("isRotation(\"waterbottle\",\"erbottlewat\"): " + sr.isRotation("waterbottle","erbottlewat"));
        System.out.println("isRotation(\"waterbottla\",\"erbottlewat\"): " + sr.isRotation("waterbottla","erbottlewat"));
    }

    /**
     * Check whether s2 is a substring of s1.
     * @param s1
     * @param s2
     * @return true if s2 is a substring of s1. false otherwise
     */
    public boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    /**
     * Check whether String s2 is a rotation of String s1 using only one call to isSubstring.
     * @param s1
     * @param s2
     * @return true if s2 is a rotation of s1. false otherwise
     */
    public boolean isRotation(String s1, String s2){
        if (s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }
        String s2s2 = s2 + s2;
        return isSubstring(s2s2,s1);
    }
}
