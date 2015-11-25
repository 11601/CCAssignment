/**
 * Created by Hakim on 10/3/15.
 */

/**
 * 5.8.
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        System.out.println("Screen 1: ");
        byte[] b = {58,58,58,58,58,58};
        solution08.printScreen(b, 16);
        solution08.drawLine(b, 16, 0, 6, 2);
        System.out.println();
        System.out.println();
        solution08.printScreen(b, 16);

        System.out.println("\n\nScreen 2: ");
        byte[] c = {0,0,0,0,0,0};
        solution08.printScreen(c, 24);
        solution08.drawLine(c, 24, 8, 9, 1);
        System.out.println();
        System.out.println();
        solution08.printScreen(c, 24);


    }

    /**
     * Draw a horizontal line in screen between (x1,y) and (x2,y).
     * @param screen
     * @param width = 8*k; k > 0
     * @param x1
     * @param x2
     * @param y
     */
    public void drawLine(byte[] screen, int width, int x1, int x2, int y){
        // compute index of the first and last bytes affected
        int startByte = y*(width/8) + x1/8;
        int endByte = y*(width/8) + x2/8;

        // compute offset inside byte
        int startOffset = 7-x2%8;
        int endOffset = 7-x1%8;

        // if startByte == endByte, set bits between startOffset and endOffset to 1
        if (startByte == endByte){
            setBitsToOne(screen, startByte, startOffset, endOffset);
        }
        // otherwise set first byte and last byte before setting the bytes in between to all 1s
        else{
            setBitsToOne(screen, startByte, startOffset, 8);
            setBitsToOne(screen, endByte, 0, endOffset);
        }

        for (int i=startByte+1; i<endByte; i++){
            setByteToOne(screen,i);
        }
    }

    /**
     * Set a whole byte to 1s.
     * @param screen
     * @param index
     */
    public void setByteToOne(byte[] screen, int index){
        screen[index] = (byte) -1;
    }

    /**
     * Set bits between offset1 and offset2 to 1 in bit at position index of screen.
     * @param screen
     * @param index
     * @param offset1
     * @param offset2
     */
    public void setBitsToOne(byte[] screen, int index, int offset1, int offset2){
        // offset1 <= offset2
        byte part1 = (byte) (-1 << offset1);
        byte part2 = (byte) ~(-1 << (offset2+1));
        byte ones = (byte) (part1 & part2);
        screen[index] = (byte) (screen[index] | ones);
    }

    /**
     * Helper method to print the whole screen.
     * @param screen
     * @param width
     */
    public void printScreen(byte screen[], int width){
        for (int i=0; i<screen.length; i++){
            if (8*i % width == 0 && i !=0){
                System.out.println();
            }
            printByte(screen[i]);
        }
    }

    /**
     * Helper method to print a byte.
     * @param b
     */
    public void printByte(byte b){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<8; i++){
            if (((int)b & 1) == 1){
                sb.append("*");
            }
            else{
                sb.append(".");
            }
            b >>= 1;
        }

        System.out.print(sb.reverse().toString());
    }
}
