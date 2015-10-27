/**
 * Created by Hakim on 10/12/15.
 */

/**
 * 8.11.
 */
public class Solution11 {
    public static void main(String[] args){
        Solution11 solution11 = new Solution11();
        System.out.println("number of ways of representing " + 0 + ": " + solution11.numWays(0));
        System.out.println("number of ways of representing " + 1 + ": " + solution11.numWays(1));
        System.out.println("number of ways of representing " + 2 + ": " + solution11.numWays(2));
        System.out.println("number of ways of representing " + 5 + ": " + solution11.numWays(5));
        System.out.println("number of ways of representing " + 10 + ": " + solution11.numWays(10));
        System.out.println("number of ways of representing " + 25 + ": " + solution11.numWays(25));
        System.out.println("number of ways of representing " + 100 + ": " + solution11.numWays(100));
    }

    /**
     * Given an infinite number of quarters, dimes, nickels, and pennies, calculate the
     * number of ways of representing n cents.
     * @param n
     * @return
     */
    public int numWays(int n){
        if (n == 0){
            return 0;
        }
        int[] divisors = {25, 10, 5, 1};
        int[][] memo = new int[n+1][divisors.length];
        return numWays(n, divisors, memo, 0);
    }

    /**
     * Helper function to calculate numWays of n cents.
     * @param n
     * @param divisors
     * @param memo
     * @param index
     * @return
     */
    public int numWays(int n, int[] divisors, int[][] memo, int index){
        if (index == divisors.length-1){    // one way to represent using pennies
            return 1;
        }
        if (memo[n][index] == 0){
            int div = divisors[index];
            for (int i=0; i<=n; i+=div){
                // numWays is the number of ways using 0 to n/div div
                memo[n][index] += numWays(n-i, divisors, memo, index+1);
            }
        }

        return memo[n][index];
    }
}
