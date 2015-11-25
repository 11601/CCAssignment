/**
 * Created by Hakim on 10/2/15.
 */

/**
 * 5.1.
 */
public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();
        int N = (1 << 10);
        int M = 19;
        int inserted = solution01.insertBits(N, M, 2, 6);
        System.out.println("Inserted: (expect 1100) " + inserted);

    }

    /**
     * Given two 32 bits numbers and two bit positions, insert M in
     * N between bits i and j.
     * @param N
     * @param M
     * @return
     */
    public int insertBits(int N, int M, int i, int j){
        // Clear bits between i and j in N
        int mask = ~((~0 >>> (31-(j-i))) << i);
        return (N & mask) | (M << i);
    }
}
