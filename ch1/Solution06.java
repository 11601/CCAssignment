/**
 * Created by Hakim on 9/9/15.
 * Compress a String using the characters count
 */
public class Solution06 {
    public static void main(String[] args){
        Solution06 sc = new Solution06();
        System.out.println(sc.compressString("aabcccccaaa"));
        System.out.println(sc.compressString("abccd"));
    }

    /**
     * Perform String compression using the counts of the characters in the String.
     * @param s - String to compress
     * @return - Compressed String
     */
    public String compressString(String s){
        // If the compressed String is not actually smaller than s, then return s
        if (s.length() <= 2 || !isCompression(s)){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i=1; i<s.length(); i++){
            // If new character is seen, then append the previous one with its count
            if (s.charAt(i) != s.charAt(i-1)){
                sb.append(s.charAt(i-1));
                sb.append(count);
                count = 1;
            }
            else{
                count++;
            }
        }

        // Append the last character if it was the same as the previous one
        if (s.charAt(s.length()-1) == s.charAt(s.length()-2)){
            sb.append(s.charAt(s.length()-1));
            sb.append(count);
        }

        // Return the compressed String only if it is actually a compression
        if (sb.length() < s.length()){
            return sb.toString();
        }
        else{
            return s;
        }
    }

    /**
     * Check whether the compressed String would actually be smaller than the input one.
     * @param s - String to compress
     * @return - true if the compressed String would be smaller than the input one
     */
    public boolean isCompression(String s){
        int result = 0;
        int count = 1;

        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) != s.charAt(i-1)){
                result += 1 + String.valueOf(count).length();
                count = 1;
            }
            else{
                count++;
            }
        }

        if (result < s.length()){
            return true;
        }
        return false;
    }
}
