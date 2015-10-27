import java.util.Stack;

/**
 * Created by Hakim on 10/11/15.
 */

/**
 * 8.6.
 */
public class Solution06 {
    public static void main(String[] args){
        Solution06 solution06 = new Solution06();
        Stack<Integer> tower1 = new Stack<>();
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();

        for (int i=9; i>=0; i--){
            tower1.push(i);
        }

        System.out.println("Tower 1 before: " + tower1);
        System.out.println("Tower 2 before: " + tower2);
        System.out.println("Tower 3 before: " + tower3);

        solution06.moveDisks(tower1.size(), tower1, tower2, tower3);

        System.out.println("Tower 1 after: " + tower1);
        System.out.println("Tower 2 after: " + tower2);
        System.out.println("Tower 3 after: " + tower3);
    }

    /**
     * move the disks from tower1 to tower3, using tower2 as a buffer and respecting the
     * constraints defined in the Towers of Hanoi problem:
     * - Only one disk can be moved at a time
     * - A disk is slid off the top of one tower onto the next tower
     * - A disk can only be placed on top of a larger disk.
     * @param n - Number of disks to move from tower1 to tower3
     * @param tower1
     * @param tower2
     * @param tower3
     */
    public void moveDisks(int n, Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3){
        if (tower1.size() == 0){
            return;
        }

        if (n == 1){
            moveOneDisk(tower1, tower3);
            return;
        }

        moveDisks(n-1, tower1, tower3, tower2);
        moveOneDisk(tower1, tower3);
        moveDisks(n-1, tower2, tower1, tower3);
    }

    /**
     * Move the top disk from origin to destination.
     * @param origin
     * @param destination
     */
    public void moveOneDisk(Stack<Integer> origin, Stack<Integer> destination){
        int top = origin.pop();
        destination.push(top);
        return;
    }
}
