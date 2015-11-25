import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Hakim on 9/30/15.
 */
public class Solution07 {
    public static void main(String[] args) throws Exception{    // should handle it
        Solution07 solution07 = new Solution07();
        String file  = "src/input1";
        System.out.println("generate missing v1: " + solution07.generateMissingInt(file));
        System.out.println("generate missing v2: " + solution07.generateMissingIntV2(file));
    }

    public int generateMissingInt(String inputFile) throws Exception{
        // create bit vector that can store all the non negative ints
        // for each integer read in the inputFile,
        // we mark this int with a bit 1 in the corresponding place
        byte[] bitVector = new byte[Integer.MAX_VALUE/8+1];

        // read file line by line
        Scanner scanner = new Scanner(new File(inputFile));
        while (scanner.hasNextInt()){
            int current = scanner.nextInt();
            addToBitVector(bitVector, current);
        }

        // read the bit vector, searching for a 0 bit
        int zeroBit = -1;
        for (int i=0; i<bitVector.length; i++){
            zeroBit = findZerobit(bitVector[i], i);
            if (zeroBit > -1){
                break;
            }
        }

        return zeroBit;
    }

    public void addToBitVector(byte[] bitVector, int current){
        // find index
        int index = findIndex(current);
        // find offset
        int offset = findOffset(current);
        int mask = createMask(offset);
        bitVector[index] |= mask;
    }

    public int findIndex(int number){
        return number/8;
    }

    public int findOffset(int number){
        return number%8;
    }

    public int createMask(int offset){
        return (1<<offset);
    }

    public int findZerobit(int number, int index){
        int offset = 0;
        for (int i=0; i< 8; i++){
            if ((number & 1) == 0){
                break;
            }
            else{
                number = number>>1;
                offset++;
            }
        }

        return 8 * index + offset;
    }


    /**
     * Follow up: What if only 10MB of memory available and all the
     * numbers are distinct.
     * No more than 1b values.
     * @return
     */
    public int generateMissingIntV2(String inputFile) throws FileNotFoundException{
        int[] array = new int[(1<<20)]; // 2^(31-20) ints per index = 2^11
        byte[] bitVector = new byte[(1<<8)];

        Scanner scanner = new Scanner(new File(inputFile));
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            incrementArray(array, n);
        }

        int missingRange = 0;
        // check the number of elements in each range
        for (int i=0; i<array.length; i++){
            if (array[i] < (1<<11)){
                missingRange = i;
                break;
            }
        }

        // copy all the elements in missingRange in the bitVector
        scanner = new Scanner(new File(inputFile));
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            if (missingRange * (1<<11) <= n && n < (missingRange+1)*(1<<11)){
                addToBitVector(bitVector,n);
            }
        }

        // Search the bit vector for a 0 bit
        int num = findZeroBit(bitVector,missingRange * (1<<11));

        return num;
    }

    public int findZeroBit(byte[] bitVector, int beginRange){
        int index = 0;
        int offset = 0;

        for (int i=0; i< bitVector.length; i++){
            if (bitVector[i] != 0xff){
                index = i;
                break;
            }
        }
        int number = bitVector[index];

        for (int i=0; i< 8; i++){
            if ((number & 1) == 0){
                break;
            }
            else{
                number = number>>1;
                offset++;
            }
        }

        return beginRange + 8 * index + offset;
    }

    public void incrementArray(int[] array, int n){
        array[n/(1<<11)]++;
    }

}
