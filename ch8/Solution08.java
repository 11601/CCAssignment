import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hakim on 10/13/15.
 */

/**
 * 8.8.
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        System.out.println(solution08.permutations("aab"));
    }

    /**
     * Compute all the permutations of a string whose characters are not necessarily unique.
     * The list of permutations should not have duplicates
     * The previous method (8.7) combined with a set to keep
     * unique elements only would work here, but would not be efficient if
     * there are many duplicate characters as we would recompute the same permutations
     * many times to discard them.
     * The permutations can be computed by choosing the first character once for
     * each unique character and then recursively computing the sub permutations
     * We keep track of the counts for each character
     * @param s
     * @return
     */
    public List<String> permutations(String s){
        if (s == null){
            return null;
        }
        Map<Character, Integer> counts = new HashMap<>();
        int remainder = s.length();  // sum of the counts
        for (char c : s.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 1);
            }
            else {
                counts.put(c, counts.get(c)+1);
            }
        }

        return permutations(counts, remainder);
    }

    /**
     * Helper function to permute a string of size remainder
     * containing counts elements of each character.
     * @param counts
     * @param remainder
     * @return
     */
    public List<String> permutations(Map<Character, Integer> counts, int remainder){
        if (remainder == 0){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        if (remainder == 1){
            List<String> result = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : counts.entrySet()){
                if (entry.getValue() == 1){
                    result.add(entry.getKey().toString());
                }
            }
            return result;
        }

        List<String> result = new ArrayList<>();
        for (Character c : counts.keySet()){
            if (counts.get(c) > 0){
                counts.put(c, counts.get(c)-1);
                for (String st : permutations(counts, remainder-1)){
                    result.add(c.toString() + st);
                }
                counts.put(c, counts.get(c)+1);
            }
        }
        return result;
    }
}
