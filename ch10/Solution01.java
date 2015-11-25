/**
 * Created by Hakim on 9/27/15.
 */
public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();
        int[] arrayA = {0,1,4,7,0,0,0};
        int numElementsA = 4;
        int[] arrayB = {2,3,8};

        solution01.mergeSort(arrayA,arrayB,numElementsA);
        for (int i=0; i<arrayA.length; i++){
            System.out.print(arrayA[i] + " ");
        }
    }

    /**
     * Given two sorted arrays arrayA and arrayB, where arrayA haas large enough buffer at
     * the end to hold arrayB, merge arrayB into arrayA in sorted order.
     * @param arrayA
     * @param arrayB
     * @param numElementsA - number of elements of A (excluding buffer)
     */
    public void mergeSort(int[] arrayA, int[] arrayB, int numElementsA){
        if (arrayB.length == 0){
            return;
        }

        int pointA = numElementsA-1;    // point to the last number in arrayA not sorted
        int last = arrayA.length-1; // point to the last element in arrayA
        int pointB = arrayB.length-1;    // point to the last element in arrayB not sorted

        while (pointA >= 0 && pointB >= 0){
            if (arrayA[pointA] > arrayB[pointB]){
                arrayA[last] = arrayA[pointA];
                pointA--;
            }
            else{
                arrayA[last] = arrayB[pointB];
                pointB--;
            }
            last--;
        }

        if (pointB < 0){
            return;
        }
        if (pointA < 0){
            while (pointB >= 0){
                arrayA[last] = arrayB[pointB];
                pointB--;
                last--;
            }
        }
    }
}
