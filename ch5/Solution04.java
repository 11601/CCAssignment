/**
 * Created by Hakim on 10/6/15.
 */
public class Solution04 {
    public static void main(String[] argv){
        Solution04 solution04 = new Solution04();

        System.out.println("getNext(14) = getNext(" + Integer.toBinaryString(14) + ") = " + solution04.getNext(14)
               + " = " + Integer.toBinaryString(solution04.getNext(14)));

        System.out.println("getNext(15) = getNext(" + Integer.toBinaryString(15) + ") = " + solution04.getNext(15)
                + " = " + Integer.toBinaryString(solution04.getNext(15)));

        System.out.println("getPrevious(14) = getPrevious(" + Integer.toBinaryString(14) + ") = " +
                solution04.getPrevious(14) + " = " + Integer.toBinaryString(solution04.getPrevious(14)));

        System.out.println("getPrevious(15) = getPrevious(" + Integer.toBinaryString(15) + ") = " +
                solution04.getPrevious(15) + " = " + Integer.toBinaryString(solution04.getPrevious(15)));


    }

    /**
     * Get the next number greater than n with the same number of 1 bits (return -1 if no such numbers).
     * @param n
     * @return
     */
    public int getNext(int n){
        // flip the smallest non trailing zero
        // first find the index of this bit
        int idx = 0;
        int m = n;
        while (((m & 1) != 1) & idx < 32){
            m >>= 1;
            idx++;
        }

        while (((m & 1) != 0) & idx < 32){
            m >>= 1;
            idx++;
        }

        // if idx >= 31, then the number is now negative or no trailing zero was found, impossible (return -1)
        if (idx > 30){
            return -1;
        }
        int mask = (1 << idx);

        // flip this bit
        n |= mask;

        // Replace the bits to the right of the flipped 0 by
        // the smallest number with the number of 1 bits there -1
        n = replaceOneBitsRight(n, idx);

        return n;
    }

    /**
     * Get largest positive number smaller than n with the same number of 1 bits (return -1 if no such number).
     * @param n
     * @return
     */
    public int getPrevious(int n){
        // flip the smallest non trailing one
        // first find the index of this bit
        int idx = 0;
        int m = n;

        if ((m & 1) == 1){
            return -1;  // no smaller number with the same number of 1 bits
        }

        while (((m & 1) != 0) & idx < 32){
            m >>= 1;
            idx++;
        }

        while (((m & 1) != 1) & idx < 32){
            m >>= 1;
            idx++;
        }

        if (idx > 30){
            // no positive number strictly smaller than n with the same number of bits
            return -1;
        }

        int mask = ~(1 << idx);

        // flip this bit
        n &= mask;

        // Replace the bits to the right of the flipped 0 by
        // the smallest number with the number of 1 bits there -1
        n = replaceZeroBitsRight(n, idx);

        return n;
    }

    /**
     * Count the number of 1 bits to the right (excluded) of idx bit,
     * replace them by cnt-1 adjacent bits starting from zero index.
     * @param n
     * @param idx
     * @return
     */
    public int replaceOneBitsRight(int n, int idx){
        // count the number of 1 bits
        int cnt = 0;

        for (int i=0; i<idx; i++){
            cnt += n & 1;
            n >>= 1;
        }

        cnt--;  // flip one 1 bit
        for (int i=0; i<idx-cnt; i++){
            n <<= 1;
        }

        for (int i=0; i<cnt; i++){
            n = (n<<1) + 1;
        }

        return n;
    }

    /**
     * Count the number of 0 bits to the right (excluded) of idx bit,
     * replace them by cnt-1 adjacent 0 bits starting from zero index (the rest being 1 bits).
     * @param n
     * @param idx
     * @return
     */
    public int replaceZeroBitsRight(int n, int idx){
        // count the number of 0 bits
        int cnt = 0;

        for (int i=0; i<idx; i++){
            cnt += (n & 1) ^ 1;
            n >>= 1;
        }

        cnt--;  // flip one 0 bit
        for (int i=0; i<idx-cnt; i++){
            n = (n<<1) + 1;
        }

        for (int i=0; i<cnt; i++){
            n <<=1;
        }

        return n;
    }
}
