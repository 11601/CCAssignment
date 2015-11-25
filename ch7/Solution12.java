import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hakim on 10/26/15.
 */

class HashTable<T,V>{
    private int capacity;
    private List<LinkedList<ESet>> list;

    public HashTable(int cap){
        capacity = cap;
        // initialize
        for (int i=0; i<capacity; i++){
            list.add(null);
        }
    }

    public void put(ESet e){
        int code = Utils.hashFunction(e.key.toString(), capacity);
        if (list.get(code) == null){
            list.set(code,new LinkedList<ESet>());
            list.get(code).add(new ESet(e));
        }
        else{
            list.get(code).addFirst(new ESet(e));
        }
    }

    public boolean remove(T t){
        int code = Utils.hashFunction(t.toString(), capacity);
        if (list.get(code) == null){
            return false;
        }

        LinkedList<ESet> lst = list.get(code);
        for (int i=0; i<lst.size(); i++){
            if (lst.get(i).key.equals(t)){
                lst.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(T key){
        int code = Utils.hashFunction(key.toString(), capacity);
        LinkedList<ESet> lst = list.get(code);
        if (lst == null){
            return false;
        }
        for (int j=0; j<lst.size(); j++){
            if (lst.get(j).key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value){
        for (int i=0; i<list.size(); i++){
            LinkedList<ESet> lst = list.get(i);
            if (lst == null){
                continue;
            }
            for (int j=0; j<lst.size(); j++){
                if (lst.get(j).value.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public V get(T t){
        int code = Utils.hashFunction(t.toString(), capacity);
        LinkedList<ESet> lst = list.get(code);

        if (lst == null){
            return null;
        }
        for (int j=0; j<lst.size(); j++){
            if (lst.get(j).key.equals(t)){
                return (V) lst.get(j).value;
            }
        }
        return null;
    }

}

class ESet<T,V>{
    T key;
    V value;
    public ESet(T t, V v){
        key = t;
        value = v;
    }

    public ESet(ESet e){
        key = (T) e.key;
        value = (V) e.value;
    }
}

class Utils{
    public static int hashFunction(String s, int max){
        int result = 0;
        for (int i=0; i<s.length(); i++){
            result += s.charAt(i) % max;
        }
        return result;
    }
}


public class Solution12 {
}
