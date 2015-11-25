import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Hakim on 9/16/15.
 */

/***
 * Stack which, in addition to push and pop, has a function min which
 * returns the minimum element. push, pop and min should all operate in O(1).
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    // Create an auxiliary stack mins which keeps track
    // of the current minimum element
    Stack<Integer> mins = new Stack<>();

    // Push x into stack
    // if x is smaller than the current smallest element,
    // then add it to mins
    public void push(int x){
        stack.push(x);
        if (mins.isEmpty()){
            mins.push(x);
        }
        int currentMin = mins.peek();

        if (x <= currentMin){
            mins.push(x);
        }
    }

    // if the element popped from stack is smaller than the
    // current minimum, then update mins by popping it
    public void pop(){
        if (stack.isEmpty()){
            throw new EmptyStackException();
        }

        int current = stack.peek();
        stack.pop();

        if (mins.isEmpty()){
            return;
        }
        if (mins.peek() >= current){
            mins.pop();
        }
    }

    public int getMin(){
        return mins.peek();
    }

    public int peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}


public class Solution02{
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();
        MinStack minStack = new MinStack();

        minStack.push(3);
        minStack.push(5);
        minStack.push(7);
        minStack.push(2);
        minStack.push(4);

        System.out.println("Minimum element in stack: " + minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println("New minimum element in stack: " + minStack.getMin());
    }
}

