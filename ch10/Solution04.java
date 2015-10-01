import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 9/28/15.
 */

/**
 * Define the Listy class.
 */
class Listy{
    List<Integer> lst = new ArrayList<>();

    public Listy(List<Integer> l){
        lst.addAll(l);
    }

    public int elementAt(int i){
        return lst.get(i);
    }

}

/**
 * Sorted seach, no size.
 */
public class Solution04 {
    public static void main(String[] args){
        Solution04 solution04 = new Solution04();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(10);
        l.add(-1);
        l.add(-1);

        Listy listy = new Listy(l);
        System.out.println("findIndex(listy,1) " + solution04.findIndex(listy,1));
        System.out.println("findIndex(listy,3) " + solution04.findIndex(listy,3));
        System.out.println("findIndex(listy,4) " + solution04.findIndex(listy,4));
        System.out.println("findIndex(listy,5) " + solution04.findIndex(listy,5));
        System.out.println("findIndex(listy,6) " + solution04.findIndex(listy,6));
        System.out.println("findIndex(listy,7) " + solution04.findIndex(listy,7));
        System.out.println("findIndex(listy,10) " + solution04.findIndex(listy,10));
        System.out.println("findIndex(listy,8) - not in list " + solution04.findIndex(listy,8));
    }

    /**
     * Find index of element x (positive) in Listy.
     * @param listy
     * @param x
     * @return index of x if present in list. -1 otherwise
     */
    public int findIndex(Listy listy, int x){
        // Find the size of listy
        int size = findSize(listy);

        // Do binary search on listy
        return binarySearch(listy, 0, size-1, x);
    }

    /**
     * Find size of Listy in log time.
     * @param listy
     * @return size of listy
     */
    public int findSize(Listy listy){
        if (listy == null || listy.elementAt(0) == -1){
            return 0;
        }

        int n = 1;
        while (listy.elementAt(n) > -1){
            n = 2*n;
        }
        int size = binarySearchMax(listy, n/2, n) + 1;
        return size;
    }

    /**
     * Do binary search in Listy to find element x.
     * @param listy
     * @param low
     * @param high
     * @param x
     * @return index of x if present. -1 otherwise
     */
    public int binarySearch(Listy listy, int low, int high, int x){
        if (low > high){
            return -1;
        }

        int mid = (low+high)/2;
        if (listy.elementAt(mid) == x){
            return mid;
        }
        else if (listy.elementAt(mid) < x){
            return binarySearch(listy, mid+1, high, x);
        }
        else if (listy.elementAt(mid) > x){
            return binarySearch(listy, low, mid-1, x);
        }
        return -1;
    }

    /**
     * Find largest index in Listy that is not -1.
     * @param listy
     * @param min
     * @param max
     * @return largest index different from -1 if exists. -1 otherwise
     */
    public int binarySearchMax(Listy listy, int min, int max){
        if (min > max){
            return -1;
        }

        int mid = (min+max)/2;
        if (listy.elementAt(mid) > -1 && listy.elementAt(mid+1) == -1){
            return mid;
        }
        else if (listy.elementAt(mid) == -1) {
            return binarySearchMax(listy, min, mid-1);
        }
        else if (listy.elementAt(mid) > -1){
            return binarySearchMax(listy, mid+1, max);
        }
        return -1;
    }

}
