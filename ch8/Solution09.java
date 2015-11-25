import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 10/14/15.
 */

/**
 * 8.9.
 */
public class Solution09 {
    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        int numPairs = 3;
        System.out.println(solution09.generateValidParens(numPairs));
    }

    /**
     * Generate all valid string containing numPairs of parentheses.
     * @param numPairs
     * @return
     */
    public List<String> generateValidParens(int numPairs) {
        List<String> combinations = new ArrayList<>();
        generateValidParens(numPairs, numPairs, "", combinations);
        return combinations;
    }

    /**
     * Helper function to generate all valid pairs of parenthesis.
     * @param countOpenRemaining
     * @param countCloseRemaining
     * @param current
     * @param combinations
     */
    public void generateValidParens(int countOpenRemaining,
                                      int countCloseRemaining,
                                      String current,   // would be more efficient using char array cause would
                                                        // avoid copying string over when adding one character
                                      List<String> combinations) {
        if (countCloseRemaining < countOpenRemaining){
            return; // wrote more closed parentheses than open ones. Invalid
        }

        if (countOpenRemaining == 0){
            // complete with all the closed parentheses
            String end = current;
            for (int i=0; i<countCloseRemaining; i++){
                end += ")";
            }
            combinations.add(end);
            return;
        }

        if (countCloseRemaining == 0 && countOpenRemaining == 0){
            // generated a valid string, print it
            combinations.add(current);
        }

        String addOpen = current + "(";
        String addClosed = current +")";

        // iterate with an open parenthesis at current position
        generateValidParens(countOpenRemaining-1, countCloseRemaining, addOpen, combinations);
        // iterate with a closed parenthesis at current position
        generateValidParens(countOpenRemaining, countCloseRemaining-1, addClosed, combinations);
    }


}
