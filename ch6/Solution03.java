/**
 * Created by Hakim on 10/4/15.
 */
public class Solution03 {
    public static void main(String[] args){
        String solution = "There are originally 8x8 = 64 cases, 32 of them black and 32 white.\n" +
                "Two diagonally opposed cases have the same color. Let's assume this color is black for the " +
                "cases that were removed.\n" +
                "There are now 30 black cases and 32 white. Each domino covers two cases: one black and one white.\n" +
                "Therefore, the dominos cover as many white cases as they cover black ones.\n" +
                "Since there are two more white cases than black ones, it is impossible to cover the board this way";

        System.out.println(solution);
    }


}
