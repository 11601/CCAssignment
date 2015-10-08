/**
 * Created by Hakim on 10/6/15.
 */
public class Solution10 {
    public static void main(String[] args){
        Solution10 solution10 = new Solution10();
        String solution = "1000 elements can be encoded in binary using 10 bits (2^10 = 1024 > 1000).\n" +
                "A test is positive iff we dropped poison on it. We can therefore get a binary encoding from" +
                " the 10 strips.\n" +
                "We will recover the poisoned bottle number by doing the following:\n" +
                "- Order the strips so they represent a 10 bits number\n" +
                "- Drop liquid from a bottle to all the strips for which the bottle number has a 1 bit\n" +
                "The strips will turn positive for all the bits for which the poisoned bottle has a 1 bit.\n" +
                "Hence, we will be able to reconstitute the poisoned bottle number by reading its bits on " +
                "the positive strips.\n" +
                "As we only need to perform tests one day, the number of days this approach takes is 7 days " +
                "(therefore, there is no need to explicitely take the number of days into account in " +
                "the simulation below). This " +
                "is the minimum achievable.\n" +
                "The simulation below illustrates this process.";

        System.out.println(solution);
        solution10.simulate(1000, 10, 18);
    }

    /**
     * Apply the approach described in 'solution' to get the bottle that contains the poison in one set of
     * tests.
     * @param numBottles
     * @param numStrips
     * @param poison
     */
    public void simulate(int numBottles, int numStrips, int poison){
        if ((1<<numStrips) < numBottles){
            System.out.println("Not enough strips for this approach to work");
            return;
        }

        int[] bottles = new int[numBottles];
        bottles[poison] = 1;
        int[] strips = new int[numStrips];

        System.out.println("Poison found in bottle " + findPoison(bottles, strips));
    }

    /**
     * Find the element equal to 1 in bottles.
     * @param bottles
     * @param strips
     * @return
     */
    public int findPoison(int[] bottles, int[] strips){
        // bottles[i] = 1 iff bottle i is poisoned
        // strips[i] = 1 iff strip positive

        int numBottles = bottles.length;

        for (int i=0; i<numBottles; i++){
            if (bottles[i] == 1){
                markStrips(strips, i);
                break;
            }
        }

        return readStrips(strips);
    }


    /**
     * Write the binary representation of num in array strips.
     * @param strips
     * @param num
     */
    public void markStrips(int[] strips, int num){
        for (int i=0; i<strips.length; i++){
            if ((num&1) == 1){
                strips[i] = 1;
            }
            num>>=1;
        }
    }

    /**
     * Read the number that has binary representation given by the array strips.
     * @param strips
     * @return
     */
    public int readStrips(int[] strips){
        int result = 0;
        for (int i=0; i<strips.length; i++){
            result += (1<<i) * strips[i];
        }
        return result;
    }
}
