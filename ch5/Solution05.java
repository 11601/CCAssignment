/**
 * Created by Hakim on 10/3/15.
 */
public class Solution05 {
    public static void main(String[] args){
        String solution = "((n & (n-1))) == 0 checks whether n is a power of two.\n" +
                "n-1 set the lowest 1 bit in n to 0 and all the bits to its right to " +
                "1s.\n" +
                "n & (n-1) will then set return a number for which all the bits to the right of " +
                " the rightmost one bit of 1 (this bit included) is set to 0.\n" +
                "(n & (n-1) == 0) iff all the bits to the left of this rightmost 1 bit are 0. " +
                "That is, n contains one and only one bit set to 1. This is equivalent to say that n is a " +
                "power of 2";
        System.out.println(solution);
    }
}
