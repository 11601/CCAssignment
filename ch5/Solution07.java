/**
 * Created by Hakim on 10/3/15.
 */
public class Solution07 {
    public static void main(String[] args){
        Solution07 solution07 = new Solution07();
        int n = 37;
        System.out.println("Pairwise swap V1 of " + Integer.toBinaryString(n) + ": " + Integer.toBinaryString(solution07.swapBitsV1(n)));
        System.out.println("Pairwise swap V2 of " + Integer.toBinaryString(n) + ": " + Integer.toBinaryString(solution07.swapBitsV2(n)));
    }

    /**
     * Swap odd and even bits of a number n.
     * Solution 1: Right shift n by 1 | Left shift n by 1 | mask removing the extra one bit that could be created on the
     * left
     * @param n
     * @return
     */
    public int swapBitsV1(int n){
        int msk = maskMSOneBit(n);
        return ((n<<1) | (n>>1)) & ~(msk << 1);
    }

    /**
     * Create a mask to set n's most significant 1 bit to 0.
     * @param n
     * @return
     */
    public int maskMSOneBit(int n){
        int msk = 0;
        while ((n & (n & (n-1))) != 0){
//            System.out.println("mask " + msk);
            msk = n & (n-1);
            n = n & msk;
        }
        return msk;
    }

    /**
     * Solution 2 using less operations.
     * Extract even bits and odd bits using masks. Logical right shift the even bits, left shift the odd bits and 'or'
     * the results
     * This solution is implemented for 32-bit integers (change the masks if 64-bit integers)
     * @param n
     * @return
     */
    public int swapBitsV2(int n){
        // logical shift for the even bits as don't want to add a 1 if msb is 1
        return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
    }
}
