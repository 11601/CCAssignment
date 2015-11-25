/**
 * Created by Hakim on 9/29/15.
 */

/**
 * Peaks and Valleys.
 */
public class Solution11 {
    public static void main(String[] args){
        Solution11 solution11 = new Solution11();
        int[] array = {5,3,1,2,3};
        System.out.println("Before rearranging:");
        solution11.printArray(array);
        solution11.rearrangePeaksValleys(array);
        System.out.println("\nAfter rearranging:");
        solution11.printArray(array);

        int[] array2 = {1,2,6,2,3,7,7,7,55,3,1,2,3};
        System.out.println("\nBefore rearranging:");
        solution11.printArray(array2);
        solution11.rearrangePeaksValleys(array2);
        System.out.println("\nAfter rearranging:");
        solution11.printArray(array2);
    }

    /**
     * Rearrange an array into a succession of peaks and valleys.
     * @param array
     */
    public void rearrangePeaksValleys(int[] array){
        // Rearrange array into a sequence of peaks/valleys (starting with a peak)
        int len = array.length;
        if (len < 2){
            return;
        }

        // Rearrange the first two elements to start with a peak
        if (array[1] > array[0]){
            swap(array, 0, 1);
        }
        if (len == 2){
            return;
        }

        // Go every two elements in the array and make it a peak
        // the other elements will automatically become valleys
        for (int i=2; i<len; i+=2){
            if (i == len-1){
                // if last element, make sure it is greater than the previous one
                if (array[i] < array[i-1]){
                    swap(array, i-1, i);
                }
            }
            else{
                rearrange(array,i);
            }
        }
    }

    /**
     * Swap two elements in an array.
     * @param array
     * @param idx0
     * @param idx1
     */
    public void swap(int[] array, int idx0, int idx1){
        int tmp = array[idx0];
        array[idx0] = array[idx1];
        array[idx1] = tmp;
    }

    /**
     * Rearrange three consecutive elements in an array such that
     * the smallest comes first, then the biggest, and finally the middle one.
     * @param array
     * @param i
     */
    public void rearrange(int[] array, int i){
        // rearrange array such that array[i] is
        // greater than array[i-1] and array[i+1]
        int min = Math.min(array[i-1], Math.min(array[i], array[i+1]));
        int max = Math.max(array[i - 1], Math.max(array[i], array[i + 1]));
        int med = (array[i-1] != min && array[i-1] != max) ? array[i-1] : (array[i] != min && array[i] != max) ? array[i] : array[i+1];

        array[i-1] = min;
        array[i] = max;
        array[i+1] = med;
    }

    /**
     * Helper function to print an array
     * @param array
     */
    public void printArray(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
