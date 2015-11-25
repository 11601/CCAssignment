import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 9/29/15.
 */

/**
 * Find an element in a M x N matrix for which each row and column is sorted in ascending order.
 */
public class Solution09 {
    public static void main(String[] args){
        Solution09 solution09 = new Solution09();
        int[][] array =  {{0,2,4,6},{1,3,5,7},{4,6,6,8}};
        List<Integer> result1 = solution09.findElement(array,5);
        List<Integer> result10 = solution09.findElement(array,10);
        System.out.println("Position of 5 (expect 1,2): " + result1.get(0)+ ", " + result1.get(1));
        System.out.println("Position of 10 (expect -1,-1): " + result10.get(0)+ ", " + result10.get(1));
    }

    public List<Integer> findElement(int[][] array, int x){
        return findElement(array, 0, array.length-1, 0, array[0].length-1, x);
    }

    /**
     * Find an element in a M x N matrix for which each row and column is sorted in ascending order.
     * @param array
     * @param rowLow
     * @param rowHigh
     * @param colLow
     * @param colHigh
     * @param x
     * @return
     */
    public List<Integer> findElement(int[][] array, int rowLow, int rowHigh, int colLow, int colHigh, int x){
        //System.out.println("rowLow " + rowLow + " rowHigh " + rowHigh + " colLow " + colLow + " colHigh " + colHigh);

        if (rowLow > rowHigh || colLow > colHigh){
            return minusOnes();
        }

        int rowMiddle = (rowLow + rowHigh)/2;
        int colMiddle = (colLow + colHigh)/2;

        if (array[rowMiddle][colLow] == x){
            return coordinates(rowMiddle,colLow);
        }
        else if (array[rowMiddle][colLow] < x){
            if (array[rowMiddle][colHigh] < x){
                rowLow = rowMiddle + 1;
            }
            else{
                rowLow = rowMiddle;
            }
        }
        else {
            rowHigh = rowMiddle-1;
        }

        if (rowLow > rowHigh){
            return minusOnes();
        }

        if (array[rowLow][colMiddle] == x) {
            return coordinates(rowLow, colMiddle);
        }
        else if (array[rowLow][colMiddle] < x) {
            if (array[rowHigh][colMiddle] < x){
                colLow = colMiddle + 1;
            }
            else{
                colLow = colMiddle;
            }
        }
        else {
            colHigh = colMiddle-1;
        }

        return findElement(array, rowLow, rowHigh, colLow, colHigh, x);
    }

    public List<Integer> minusOnes(){
        List<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        return result;
    }

    public List<Integer> coordinates(int x, int y){
        List<Integer> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        return result;
    }

}
