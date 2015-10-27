/**
 * Created by Hakim on 10/11/15.
 */

/**
 * 8.5.
 */
public class Solution05 {
    public static void main(String[] args){
        Solution05 solution05 = new Solution05();
        System.out.println("65 * 3 = " + solution05.recursiveMultiply(65, 3));
    }


    /**
     * Recursive multiply.
     * Multiply m by n without using '*'
     * recursively multiply min(m,n)/2 by max(m,n)
     * if min == 1, return max
     * if min is odd, add max to the result
     * @param m
     * @param n
     * @return
     */
    public int recursiveMultiply(int m, int n){
        int maxi = Math.max(m, n);
        int mini = Math.min(m, n);

        if (m != mini){
            return recursiveMultiply(mini, maxi);
        }

        if (m == 1){
            return maxi;
        }

        int div = recursiveMultiply(mini/2, maxi);
        int rest = (mini % 2 == 0) ? 0 : maxi;

        return div + div + rest;
    }
}
