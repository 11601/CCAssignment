/**
 * Created by Hakim on 10/3/15.
 */

/**
 * 5.6.
 */
public class Solution06 {
    public static void main(String[] args){
        Solution06 solution06 = new Solution06();
        int a = 29, b = 15;
        System.out.println("Number of bits to be flipped to convert " +
                " " + a + " to " + b + ": " + solution06.numberOfFlips(a,b));
    }

    /**
     * Determine the number of bits ou would need to flip to convert integer a to integer b.
     * @param a
     * @param b
     * @return number of bits to flip to convert a to b
     */
    public int numberOfFlips(int a, int b){
        // a ^ b creates a number whose binary representation has 1s iff the corresponding bits of a and b are different
        int diff = a ^ b;
        return countNumberOneBits(diff);
    }

    /**
     * Count the number of one bits in integer n.
     * @param n
     * @return number of '1' bits in n
     */
    public int countNumberOneBits(int n){
        // while n!= 0, do logical right shifts and compare the lsb of n to 1
        int number = 0;

        while (n != 0){
            number += n & 1;
            n >>>= 1;
        }

        return number;

        // NOTE: Alternatively, instead of shifting n repeatedly to count the number of 1 bits, repeatedly
        // clear the least significant 1 bit : n & n-1
    }
}
