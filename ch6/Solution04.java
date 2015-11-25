/**
 * Created by Hakim on 10/4/15.
 */

/**
 * 6.4.
 */
public class Solution04 {
    public static void main(String[] args){
        String solution = "The probability that a collision occurs is 1 - Pr(all ants walk on the same direction).\n" +
                "Let's consider Pr(all ants walk on the same direction):\n" +
                "Pr(all ants walk on the same direction) = Pr(all ants walk in direction 1) + Pr(all ants walk in direction 2).\n" +
                "Pr(all ants walk in direction 1) = Pr(ant1 walks in direction 1 and ant2 walks in direction 1) and ant3 walks in direction 1 \n" +
                "By independence: Pr(all ants walk in direction 1) =  Pr(ant1 walks in direction 1) * Pr(ant2 walks in direction 1) * Pr(ant3 walks in direction 1)\n" +
                "Pr(all ants walk in direction 1) = (1/2)^3\n" +
                "Likewise, Pr(all ants walk in direction 2) = (1/2)^3.\n" +
                "Hence, Pr(all ants walk on the same direction) = (1/2)^3 * 2 = 1/4\n" +
                "Finally, the probability that a collision occurs is 1 - Pr(all ants walk on the same direction) = 1 - 1/4" +
                "The probability that a collision occurs is 3/4\n" +
                "\n" +
                "FOLLOW UP n ants on an n-vertex polygone:" +
                "The probability that a collision occurs is 1 - Pr(all ants walk on the same direction).\n" +
                "Pr(all ants walk on the same direction) = Pr(all ants walk in direction 1) + Pr(all ants walk in direction 2)\n" +
                "Pr(all ants walk on the same direction) = 2 * (1/2)^n = (1/2)^(n-1)\n" +
                "and The probability that a collision occurs is 1 - (1/2)^(n-1)";

        System.out.println(solution);
    }
}
