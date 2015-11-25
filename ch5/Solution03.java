/**
 * Created by Hakim on 10/2/15.
 */

/**
 * 5.3.
 */
public class Solution03 {
    public static void main(String[] args){
        Solution03 solution03 = new Solution03();
        System.out.println("Longest possible sequence for " + Integer.toBinaryString(1775) + ": " + solution03.lengthLongestSequence(1775));
    }

    /**
     * Find the length of the longest sequence of 1s you can create in the binary representation of an integer, begin
     * able to flip exaclty one 0 to a 1.
     * @param n
     * @return
     */
    public int lengthLongestSequence(int n){
        int longest = 0;
        int begin = 0, end = 0;
        boolean hasZero = false;

        int currentBit = 0;
        while (n != 0){
            if ((n & 1) == 0){
                if (hasZero){
                    longest = ((end-begin+1) > longest) ? (end-begin+1) : longest;
                    hasZero = false;
                    begin = currentBit+1;
                    end = currentBit+1;
                }
                else{
                    hasZero = true;
                    end = currentBit;
                }
            }
            else{
                end = currentBit;
            }

            n >>= 1;
            currentBit++;
        }
        // if MSB is 1
        longest = ((end-begin+1) > longest) ? (end-begin+1) : longest;

        return longest;
    }
}
