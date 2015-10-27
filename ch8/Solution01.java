/**
 * Created by Hakim on 10/9/15.
 */
public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();
        System.out.println("Number of ways of climbing " + 9 + " staircases: " + solution01.numWays(9));
    }

    /**
     * Compute the number of ways to climb n stairs hopping 1, 2, or 3 cases.
     * NOTE: Will quickly overflow. Can use BigInteger to address this issue
     * @param n
     * @return
     */
    public int numWays(int n){
        return numWays(n, new int[n+1]);
    }

    /**
     * Compute the number of ways to climb n stairs hopping 1, 2, or 3 cases using memoization.
     * @param n
     * @param result
     * @return
     */
    public int numWays(int n, int[] result){
        if (n == 0 || n < 3){
            return n;
        }

        if (result[n] == 0){
            result[n] = numWays(n-1, result) + numWays(n-2, result) + numWays(n-3, result);
        }

        return result[n];
    }
}
