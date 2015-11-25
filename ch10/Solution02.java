import java.util.*;

/**
 * Created by Hakim on 9/27/15.
 */
public class Solution02 {
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();
        String[] arr = {"", "abcd", "dcab", "cdab", "aer", "are", "e"};
        solution02.groupAnagrams(arr);
        solution02.printArray(arr);
    }

    /**
     * Sort array of strings so that all the anagrams are next to each other.
     * @param array
     */
    public void groupAnagrams(String[] array){
        Map<String, List<String>> anagrams = new HashMap<>();

        for (int i=0; i<array.length; i++){
            addElement(anagrams, array[i]);
        }

        int i = 0;
        for (Map.Entry<String, List<String>> e : anagrams.entrySet()){
            List<String> lst = e.getValue();
            for (String s : lst) {
                array[i] = s;
                i++;
            }
        }
    }

    /**
     * Add element to HashMap, creating a new entry if none exists already.
     * @param map
     * @param toAdd
     */
    public void addElement(Map<String, List<String>> map, String toAdd){
        char[] arrayToAdd = toAdd.toCharArray();
        Arrays.sort(arrayToAdd);
        if (map.containsKey(arrayToAdd.toString())){    // can't use array as equal points to specific object
            map.get(arrayToAdd.toString()).add(toAdd);
        }
        else{
            List<String> lst = new ArrayList<>();
            lst.add(toAdd);
            map.put(arrayToAdd.toString(),lst);
        }
    }

    public void printArray(String[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
