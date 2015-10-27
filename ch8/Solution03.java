/**
 * Created by Hakim on 10/10/15.
 */
public class Solution03 {
    public static void main(String[] args){
        Solution03 solution03 = new Solution03();
        int[] A1 = {1,2,3,4,5};
        int[] A2 = {-1,0,1,3,4,7,8,9};
        System.out.println("A magic index in A1: (expect -1) " + solution03.magicIndex(A1));
        System.out.println("A magic index in A2: (expect 3) " + solution03.magicIndex(A2));

        int[] A3 = {1,3,4,5,5,6,6};
        int[] A4 = {-1,-1,0,1,2};
        System.out.println("A magic index in A3: (expect 6) " + solution03.magicIndexWithDups(A3));
        System.out.println("A magic index in A4: (expect -1) " + solution03.magicIndexWithDups(A4));
    }

    /**
     * Given a sorted array of distinct integers, find a magic index, if one exists.
     * @param A
     * @return
     */
    public int magicIndex(int[] A){
        return magicIndex(A, 0, A.length-1);
    }

    /**
     * Find a magic index in A between low and high.
     * @param A
     * @param low
     * @param high
     * @return
     */
    public int magicIndex(int[] A, int low, int high){
        if (low > high){
            return -1;  // error value
        }

        int mid = (low + high)/2;

        if (A[mid] == mid){
            return mid;
        }
        else if (A[mid] > mid){
            // there can't be a magic index on the right side
            return magicIndex(A, low, mid-1);
        }
        else{
            // can't be a magic index on the left side
            return magicIndex(A, mid+1, high);
        }
    }


    /**
     * Follow up: If the values in A are not distinct.
     * @param A
     * @return
     */
    public int magicIndexWithDups(int[] A){
        return magicIndexWithDups(A, 0, A.length-1);
    }

    /**
     * Find a magic index in A between low and high.
     * @param A
     * @param low
     * @param high
     * @return
     */
    public int magicIndexWithDups(int[] A, int low, int high){
        if (low > high || low < 0 || high > A.length-1){
            return -1;
        }

        int mid = (low + high)/2;

        if (A[mid] == mid){
            return mid;
        }
        else if (A[mid] < mid){
            int right = magicIndexWithDups(A, mid+1, high);
            int left = magicIndexWithDups(A, low, A[mid]);
            int magic = (right > -1) ? right:left;
            return magic;
        }
        else{
            int right = magicIndexWithDups(A, A[mid], high);
            int left = magicIndexWithDups(A, low, mid-1);
            int magic = (right > -1) ? right:left;
            return magic;
        }
    }
}
