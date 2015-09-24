import java.util.Stack;

/**
 * Created by Hakim on 9/17/15.
 */

/**
 * Sort a Stack such that the smallest items are on the top.
 * May use an additional Stack, but no other data structure
 */
public class Solution05 {
    public static void main(String[] args){
        Solution05 s = new Solution05();
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(0);

        System.out.println("Unsorted Stack: ");
        printStack(stack);
        s.sortStack(stack);
        System.out.println("Sorted Stack: ");
        printStack(stack);
    }


    /**
     * Sort a Stack such that the smallest items are on the top.
     * @param stack -  Stack to be sorted
     */
    public void sortStack(Stack<Integer> stack){
        // Additional Stack
        Stack<Integer> buffer = new Stack<>();

        if (stack == null || stack.size() < 2){
            return;
        }

        buffer.push(stack.pop());

        // Use buffer to store all the elements in reverse order
        while (!stack.isEmpty()){
            int top = stack.pop();
            int topBuffer = buffer.peek();
            while (!buffer.isEmpty() && topBuffer > top){
                stack.push(buffer.pop());
                topBuffer = buffer.peek();
            }
            buffer.push(top);
        }

        // push back the elements from buffer so stack is sorted
        while (!buffer.isEmpty()){
            stack.push(buffer.pop());
        }
    }

    /**
     * Helper method to print the elements in a Stack.
     * @param stack
     */
    public static void printStack(Stack<Integer> stack){
        for (int t : stack){
            System.out.print(t + " ");
        }
        System.out.println();
    }

}
