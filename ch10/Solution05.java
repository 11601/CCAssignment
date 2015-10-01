/**
 * Created by Hakim on 9/28/15.
 */

/**
 * Sparse search.
 */
public class Solution05 {
    public static void main(String[] args){
        Solution05 solution05 = new Solution05();
        String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println("index of ball: " + solution05.binarySearchSparse(array, "ball"));
        System.out.println("index of at: " + solution05.binarySearchSparse(array, "at"));
        System.out.println("index of dad: " + solution05.binarySearchSparse(array, "dad"));
        System.out.println("index of da (not in array): " + solution05.binarySearchSparse(array, "da"));
    }

    /**
     * Find a String in an array intersperced with empty strings.
     * @param array
     * @param target
     * @return index of the String if it exists in the array. -1 otherwise. Note that searching the
     * empty string will return an index where this string occurs if one exists
     */
    public int binarySearchSparse(String[] array, String target){
        return binarySearchSparse(array, 0, array.length-1, target);
    }

    /**
     * Recursive binary search in a sparse array.
     * @param array
     * @param low
     * @param high
     * @param target
     * @return index of target in the array if it occurs there. -1 otherwise
     */
    public int binarySearchSparse(String[] array, int low, int high, String target) {
        if (low > high){
            return -1;
        }

        int mid = (low+high)/2;

        if (array[mid].equals(target)){
            return mid;
        }
        else if (array[mid].length() != 0 && array[mid].compareTo(target) > 0){
            return binarySearchSparse(array, low, mid-1, target);
        }
        else if (array[mid].length() != 0 && array[mid].compareTo(target) < 0){
            return binarySearchSparse(array, mid+1, high, target);
        }
        else if (array[mid].length() == 0){
            int midL = mid;
            int midR = mid;

            while (midL >= low){
                if (array[midL].length() == 0){
                    midL--;
                }
                else if (array[midL].equals(target)){
                    return midL;
                }
                else if ((array[low].length() == 0 | array[low].compareTo(target) <= 0) && array[midL].compareTo(target) > 0){
                    return binarySearchSparse(array, low, midL-1, target);
                }
                else{
                    break;
                }
            }
            while (midR <= high){
                if (array[midR].length() == 0){
                    midR++;
                }
                else if (array[midR].equals(target)){
                    return midR;
                }
                else if ((array[high].length() == 0 | array[high].compareTo(target) >= 0) && array[midR].compareTo(target) < 0){
                    return binarySearchSparse(array, midR+1, high, target);
                }
                else{
                    break;
                }
            }
        }
        return -1;
    }
}
