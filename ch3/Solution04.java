import java.util.Stack;

/**
 * Created by Hakim on 9/17/15.
 */

/**
 * Implement a Queue using two Stacks.
 * @param <T>
 */
class MyQueue<T> {
    Stack<T> stack1 = new Stack<>();    // holds the old elements in a "FIFO" manner
    Stack<T> stack2 = new Stack<>();    // holds the new elements in a "FILO" manner

    public void add(T t){
        // Add new element to stack2
        stack2.push(t);
    }

    public T remove(){
        if (this.isEmpty()){
            throw new RuntimeException("Trying to remove from an empty MyQueue");
        }

        // If stack1 is not empty, it holds the oldest elements
        if (!stack1.isEmpty()){
            return stack1.pop();
        }
        else{
            // otherwise, add all the newest elements from stack2 into stack1,
            // reverting their order
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            // the oldest element is now at stack1's top
            return stack1.pop();
        }
    }

    public T peek(){
        if (this.isEmpty()){
            throw new RuntimeException("Trying to peek from an empty MyQueue");
        }

        // If stack1 is not empty, it holds the oldest elements
        if (!stack1.isEmpty()){
            return stack1.peek();
        }
        else{
            // otherwise, add all the newest elements from stack2 into stack1,
            // reverting their order
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            // the oldest element is now at stack1's top
            return stack1.peek();
        }
    }

    public boolean isEmpty(){
        // check whether both stacks are empty
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class Solution04 {
    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println("queue.peek(): " + queue.peek());
        System.out.println("queue.pop(): " + queue.remove());
        System.out.println("queue.pop(): " + queue.remove());
        System.out.println("queue.pop(): " + queue.remove());
        System.out.println("queue.pop(): " + queue.remove());
        System.out.println("queue.pop(): " + queue.remove());
    }
}
