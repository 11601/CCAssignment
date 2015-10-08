/**
 * Created by Hakim on 10/4/15.
 */

/**
 * 6.5.
 */
public class Solution05 {
    public static void main(String[] args){
        String solution1 = "Solution1: If we have an extra recipient that can contain at least 9 quart:" +
                "\n1- Fill this extra recipient with the 3-quart jug three times: It will contain 9-quart." +
                "\n2- Empty the filled recipient in the 5-quart, so that 9-5 = 4-quart will remain.\n";

        String solution2 = "If we only have the 5-quart and the 3-quart:\n" +
                "1- Fill 5-quart\n" +
                "2- Empty 5-quart in 3 quart => 2 remaining in 5-quart\n" +
                "3- Empty 3-quart\n" +
                "4- Empty 5-quart in 3-quart => 2 in 3-quart\n" +
                "5- Fill 5-quart\n" +
                "6- Empty 5-quart in 3-quart is full (1) => 4 remaining in 5-quart";

        System.out.println(solution1);
        System.out.println(solution2);
    }


}
