import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by Hakim on 9/15/15.
 */
public class Solution01 {
    int N = 8;
    int[] array = new int[3*N];

    int[] begin = new int[3];
    int[] end = new int[3];
    int[] top = new int[3];

    public void initializeStacks(){
        begin[0] = 0;
        begin[1] = N;
        begin[2] = 2*N;

        end[0] = N;
        end[1] = 2*N-1;
        end[2] = 3*N-1;

        top[0] = 0;
        top[1] = N;
        top[2] = 2*N;

    }


    public void push(int stackNumber, int elt){
        if (top[stackNumber] == end[stackNumber]){
            throw new StackOverflowError();
        }
        else{
            top[stackNumber]++;
            array[top[stackNumber]] = elt;
        }
    }

    public void pop(int stackNumber){
        if (isEmpty(stackNumber)){
            throw new EmptyStackException();
        }
        else{
            top[stackNumber]--;
        }
    }

    public int peek(int stackNumber){
        if (isEmpty(stackNumber)){
            throw new EmptyStackException();
        }
        else{
            return array[top[stackNumber]];
        }
    }

    public boolean isEmpty(int stackNumber){
        return begin[stackNumber] == end[stackNumber];
    }
}
