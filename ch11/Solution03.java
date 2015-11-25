/**
 * Created by Hakim on 10/19/15.
 */
public class Solution03 {
    public static void main(String[] args){
        String solution = "Testing the canMoveTo method:\n" +
                "- For every kind of piece, test legal moves for that piece, where moving this piece " +
                "would not create a check and not eat another piece; perform these tests under different " +
                "conditions: unbalanced repartition of pieces, different types of pieces present\n" +
                "- For every kind of piece, test legal moves for that piece, where moving this piece\n" +
                " would not create a check and would eat another piece\n" +
                "- Test illegal inputs: Trying to move a piece outside the board, trying to move a null piece\n" +
                "- Test illegal moves: Generate situations where moving a piece would create a check situation for " +
                "the person who moves that piece, " +
                "try to move a piece in a way it is not allowed to\n";

        System.out.println(solution);
    }
}
