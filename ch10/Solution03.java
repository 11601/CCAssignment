/**
 * Created by Hakim on 9/27/15.
 */
public class Solution03 {
    public static void main(String[] args){
        Solution03 solution03 = new Solution03();
        int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(solution03.searchRotatedArray(array,5));
    }

    /**
     * Search rotated array.
     * @param array
     * @param x
     * @return index of x if present in array. -1 otherwise
     */
    public int searchRotatedArray(int[] array, int x){
        // Search pivot
        int pivot = findPivot(array, 0, array.length-1);
        if (pivot == -1){
            return -1;
        }

        // Do binary search on the left and right subarrays
        return Math.max(binarySearch(array,0,pivot,x), binarySearch(array,pivot+1,array.length-1,x));
    }

    /**
     * Find point where rotation occured.
     * @param array
     * @param low
     * @param high
     * @return index of pivot if exists. -1 otherwise
     */
    public int findPivot(int[] array, int low, int high) {
        if (low >= high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] > array[mid + 1]) {
            return mid;
        }
        if (array[low] >= array[high]) {
            return Math.max(findPivot(array, low, mid), findPivot(array, mid + 1, high));
        }
        else{
            return -1;
        }
    }

    /**
     * Do binary search in array between l and h.
     * @param array
     * @param l
     * @param h
     * @param x
     * @return index of x if between l and h. -1 otherwise
     */
    public int binarySearch(int[] array, int l, int h, int x){
        int low = l;
        int high = h;
        int mid;

        while (low <= high){
            mid = (low+high)/2;
            if (array[mid] > x){
                high = mid-1;
            }
            else if (array[mid] < x){
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
