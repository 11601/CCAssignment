/**
 * Created by Hakim on 10/2/15.
 */

/**
 * 5.2.
 */
public class Solution02 {
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();
        double d1 = 0.72;
        System.out.println("Representation of " + d1 + ": " + solution02.binaryToString(d1));
        double d2 = 0.5 + 0.125;
        System.out.println("Representation of " + d2 + ": " + solution02.binaryToString(d2));
    }

    /**
     * Return the binary representation of a real number between 0 and 1. Return ERROR if the binary representation
     * would require more than 32 bits.
     * @param num
     * @return
     */
    public String binaryToString(double num){
        if (num == 0 || num == 1){
            // no '.'
            return Double.toString(num);
        }

        int n = 0;    // count the number of digits needed to represent num
        for (int i=0; i<32; i++){
            if (num == Math.floor(num)){
                break;
            }
            num *= 2;
            n++;
        }

        // if more than 32 characters are needed (excluding '.'), then print "ERROR"
        if (n == 32){
            return "ERROR";
        }

        StringBuilder sb = new StringBuilder();
        while (num >= 1){
            sb.insert(0,Integer.toString((int)num&1));
            num /= 2;
        }

        sb.insert(0, ".");
        return sb.toString();
    }
}
