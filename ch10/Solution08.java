/**
 * Created by Hakim on 9/30/15.
 */

/**
 * Find duplicates.
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        int[] array = {1,2,8,2,4,5,6,8,2,3,4,10};    // duplicates: 2,8,4
        solution08.printAllDuplicates(array);
    }

    /**
     * Given an array of numbers <= N <= 32000, print all the duplicate elements.
     * @param array
     */
    public void printAllDuplicates(int[] array){
        // The maximum value N that can be contained in the array
        // is 32000
        // 32,000 bits <= 4 KB.
        // We can represent the set of values in the array using
        // a bit vector with 32,000 bits (of size 4KB)
        // We loop through the array. If a value is seen for the first
        // time, we set the corresponding bit to 1
        // otherwise we print the value

        byte[] bitVector = new byte[4000];
        for (int i=0; i<array.length; i++){
            int bucket = findCorrespondingBucket(array[i]-1);
            int offset = findCorrespondingOffset(array[i]-1);
            int mask = buildMask(offset);
            if ((bitVector[bucket] & mask) != 0){
                System.out.println(array[i]);
            }
            else{
                bitVector[bucket] |= mask;
            }
        }
    }

    /**
     * Find position of n in the bit vector array.
     * @param n
     * @return
     */
    public int findCorrespondingBucket(int n){
        // find the array index of n
        return n/8;
    }

    /**
     * Find the offset of the int n in its bitVector array element.
     * @param n
     * @return
     */
    public int findCorrespondingOffset(int n){
        // find the offset of n in its bucket
        return n%8;
    }

    /**
     * Build mask with all 0s except in offset's position.
     * @param offset
     * @return
     */
    public int buildMask(int offset){
        return (1<<offset);
    }

}
