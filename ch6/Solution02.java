/**
 * Created by Hakim on 10/4/15.
 */

/**
 * 6.2.
 */
public class Solution02 {
    public static void main(String[] args){
        /**
         * The probability of winning game 1 if p.
         * The probability of winning game 2 is equal to the probability of getting 2 shots out of
         * 3 attempts. We can achieve this by scoring the three shots (probability p^3) or missing at most
         * one: (1-p) * p * p of missing the first one and scoring the other two,
         * p * (1-p) * p of missing the second one and scoring the other two
         * p * p * (1-p) of scoring the first two and missing the final one.
         * Hence, the probability of winning game 2 is 3*(1-p)*p^2
         *
         * We want to play game 1 iff the probability of winning game 1 is greater than the one of winning
         * game 2, that is iff:
         *
         *     p > p^3 + 3*(1-p)*p^2
         * iff p > p^3 + 3*p^2 - 3*p^3
         * iff p > -2*p^3 + 3*p^2
         * iff 2*p^2 - 3*p + 1 > 0 or p=0 (otherwise, could not divide by p)
         * iff p^2 - 3/2*p +1/2 > 0
         * iff (p-3/4)^2 - 1/16 > 0
         * iff (p-3/4-1/4)*(p-3/4+1/4) > 0
         * iff (p-1)*(p-1/2) > 0
         * iff p < 0.5
         *
         * In conclusion, we should play game 1 iff p < 0.5, game 2 otherwise
         * (with equal chances if winning either game if p=1, 0.5, or 0 (cf 3rd iff))
         */

        String solution = "Please see comment";
        System.out.println(solution);
    }


}
