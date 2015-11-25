import java.util.Iterator;
import java.util.List;

/**
 * Created by Hakim on 10/26/15.
 */

class CircularArray<T> implements Iterable<T>{
    private int start;
    private int size;
    private List<T> arr;

    public CircularArray(int l){
        size = l;
        for (int i=0; i<l; i++){
            arr.add(null);
        }
    }

    public T get(int index){
        return arr.get((start + index + size) % size);
    }

    public void set(int index, T elt){
        arr.set((index + size + start) % size, elt);
    }

    public int getSize(){
        return size;
    }

    public void shift(int n){
        start = (start + n + size) % size;
    }

    public List<T> getArr(){
        return arr;
    }
    public Iterator<T> iterator(){
        return new CAIterator<T>(this);
    }
}

class CAIterator<T> implements Iterator<T>{
    private List<T> cpArray;
    private int offset;
    private int size;

    public CAIterator(CircularArray<T> cArr){
        cpArray = cArr.getArr();
        size = cArr.getSize();
    }

    @Override
    public boolean hasNext(){
        if (offset < size){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public T next(){
        offset++;
        return cpArray.get((offset+size) % size);
    }

    @Override
    public void remove(){
        cpArray.remove(offset);
    }
}


public class Solution09 {
}
