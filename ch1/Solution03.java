/**
 * Created by Hakim on 9/8/15.
 */

/**
 * URLify a String, replacing all whitespaces by "%20".
 */
public class Solution03 {
    public static void main(String[] args){
        Solution03 urlify = new Solution03();
        String s = "Mr John Smith    ";
        char[] c = s.toCharArray();
        urlify.urlify(c,13);
        System.out.println(c);
    }

    /**
     * URLify a character array by replacing all the spaces by "%20".
     * Assume the character array contains enough trailing whitespaces to contain the new array
     * @param c
     * @param actualLength
     */
    public void urlify(char[] c, int actualLength){
        int pointer1 = actualLength-1;
        int pointer2 = c.length-1;

        while (pointer1 >= 0){
            if (c[pointer1] == ' '){
                c[pointer2] = '0';
                c[pointer2-1] = '2';
                c[pointer2-2] = '%';

                pointer2 -= 3;
                pointer1--;
            }
            else{
                c[pointer2] = c[pointer1];
                pointer2--;
                pointer1--;
            }
        }
    }
}
