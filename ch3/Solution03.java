import java.util.*;

/**
 * Created by Hakim on 9/17/15.
 */

/**
 * Implement a set of stacks, similarly to a set of plates.
 * SetOfStacks should be composed of several stacks and should
 * create a new stack once the previous one exceeds capacity.
 * @param <T>
 */
class SetOfStacks<T> {
    List<Stack> stacks;   // stacks[0] stores the first (oldest) stack
    int capacity;   // Capacity of each stack

    public SetOfStacks(int N){
        stacks = new ArrayList<>();
        capacity = N;
    }

    public void push(T x){
        // If there is no stack in the set or the last stack is full,
        // then create a new stack and push x there
        if (stacks.size() == 0 || stacks.get(stacks.size()-1).size() == capacity){
            Stack<T> newStack = new Stack();
            newStack.push(x);
            stacks.add(newStack);
        }
        else{
            // push x to the newest stack
            stacks.get(stacks.size()-1).push(x);
        }
    }

    public T pop(){
        if (stacks.size() == 0){
            throw new EmptyStackException();
        }

        T p = (T) stacks.get(stacks.size()-1).pop();

        // If the last stack gets empty after popping it
        // remove it from the set
        if (stacks.get(stacks.size()-1).isEmpty()){
            stacks.remove(stacks.size()-1);
        }

        return p;
    }

    public T peek(){
        if (stacks.size() == 0){
            throw new EmptyStackException();
        }
        T p = (T) stacks.get(stacks.size()-1).peek();
        return p;
    }

    public boolean isEmpty(){
        return stacks.size() == 0;
    }

    /**
     * Helper method to print the set of stacks.
     * Top of each stack is on the right
     * The newest stack is at the bottom
     */
    public void printSetOfStacks(){
        for (Stack<T> stack : stacks){
            for (T t : stack){
                System.out.print(t + " | ");
            }
            System.out.println();
        }
    }

    // FOLLOW UP: Implement popAt(int index) which pops stack index
    public T popAt(int index){
        // Choose to shift all the elements in the stacks after index
        // to fill stack index
        if (stacks.size() <= index){
            throw new RuntimeException("Attempting to pop an non existing stack");
        }

        T p = (T) stacks.get(index).pop();

        // If the stack is empty, then just remove it
        // (no need to shift anything)
        if (stacks.get(index).isEmpty()){
            stacks.remove(index);
        }
        else{
            // Else, shift each stack after index
            // by adding elements to the previous stack
            // until it is full
            for (int i=index+1; i<stacks.size(); i++){
                shiftStack(i);
            }

            // If the last stack is empty, remove it
            if (stacks.get(stacks.size()-1).isEmpty()){
                stacks.remove(stacks.size()-1);
            }
        }
        return p;
    }

    public void shiftStack(int i){
        // Push the elements of the stack being
        // shifted into buffer so as to conserve the
        // ordering
        Stack<T> buffer = new Stack<>();
        while (!stacks.get(i).isEmpty()){
            buffer.push((T) stacks.get(i).pop());
        }

        // While the previous stack is not full and the current not
        // empty, empty the buffer to the new stack
        while (!buffer.isEmpty() && stacks.get(i-1).size() < capacity){
            stacks.get(i-1).push(buffer.pop());
        }

        // Put back the remaining elements in buffer into the original stack
        while (!buffer.isEmpty()){
            stacks.get(i).push(buffer.pop());
        }
    }

}



public class Solution03 {
    public static void main(String[] args){
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push(0);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);

        System.out.println(" Set of stacks ");
        setOfStacks.printSetOfStacks();
        System.out.print("Top element: " + setOfStacks.peek());
        setOfStacks.pop();
        System.out.println(" Set of stacks after removing top element: ");
        setOfStacks.printSetOfStacks();
        setOfStacks.popAt(1);
        System.out.println("Set of stacks after popping stack 1: ");
        setOfStacks.printSetOfStacks();
    }



}
