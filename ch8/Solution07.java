import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 10/12/15.
 */

/**
 * 8.7.
 */
public class Solution07 {
    public static void main(String[] args){
        Solution07 solution07 = new Solution07();
        System.out.println(solution07.permutations("abc"));
    }

    /**
     * Return the list of all the permutations of String s which doesn't contain duplicates.
     * @param s
     * @return
     */
    public List<String> permutations(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            List<String> result = new ArrayList<>();
            result.add(s);
            return result;
        }

        List<String> result = new ArrayList<>();
        char c = s.charAt(0);
        List<String> perms = permutations(s.substring(1));

        for (int index = 0; index <= perms.get(0).length(); index++) {
            for (String st : perms) {
                String t = insert(c, st, index);
                result.add(t);
            }
        }

        return result;
    }

    /**
     * Insert character c into String st in position index.
     * @param c
     * @param st
     * @param index
     * @return
     */
    public String insert(char c, String st, int index){
        String prefix = st.substring(0,index);
        String suffix = st.substring(index,st.length());
        return prefix + c + suffix;
    }

}
