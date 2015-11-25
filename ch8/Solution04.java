import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hakim on 10/11/15.
 */

/**
 * 8.4.
 */
public class Solution04 {
    public static void main(String[] args){
        Solution04 solution04 = new Solution04();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Set<HashSet<Integer>> subsets = solution04.findAllSubsets(set);
        for (Set<Integer> s : subsets){
            System.out.println(s);
        }
    }

    /**
     * Return all the subsets of set.
     * @param set
     * @return
     */
    public Set<HashSet<Integer>> findAllSubsets(Set<Integer> set){
        if (set.isEmpty()){
            return new HashSet<>();
        }

        Set<HashSet<Integer>> result = new HashSet<>();

        result.add(new HashSet<Integer>()); // add the empty set

        // For every element, add the sets of size at most maxSizePreviousSets+1 that
        // contain this element
        for (Integer i : set){
            List<HashSet<Integer>> tmp = new ArrayList<>();
            for (HashSet<Integer> s : result){
                tmp.add((HashSet)s.clone());
            }
            for (HashSet<Integer> s : tmp){
                s.add(i);
                result.add(s);
            }
        }
        return result;
    }
}
