/**
 * Created by Hakim on 10/19/15.
 */
public class Solution01 {
    public static void main(String[] args){
        String solution = "i being unsigned, printf should use %u instead of %d\n" +
                "The method will loop infinitely as i is unsigned and will always respect the" +
                " condition i>=0.\n" +
                "We can print all the numbers between 100 and 1 replacing it by for (i=100; i>0;--i)\n" +
                "and can additionally print 0 if we want after the loop.";
        System.out.println(solution);
    }
}
