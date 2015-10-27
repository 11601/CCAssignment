import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by larbi on 10/14/15.
 */
public class Solution13 {
/*
 * Complete the function below.
 */

    static long highestStack(int[][] boxes) {
        // Sort the boxes in descending width
        Arrays.sort(boxes, new Comparator<int[]>(){
            @Override
            public int compare(int[] box1, int[] box2){
                int width1 = box1[0];
                int width2 = box2[0];
                if (width1 == width2){
                    return 0;
                }
                if (width1 > width2){
                    return -1;
                }
                else{
                    return +1;
                }
            }
        });

        // save results to avoid duplicate computations
        long[] memo = new long[boxes.length];

        long max = 0;
        for (int base=0; base<boxes.length; base++){
            long h = highestStack(boxes, memo, base);
            max = Math.max(max, h);
        }

        return max;
    }

    /**
     * Helper method to compute highest stack starting from the box at index begin
     */
    static long highestStack(int[][] boxes, long[] memo, int begin){
        if (begin > boxes.length-1){
            return 0;
        }

        if (memo[begin] > 0){
            return memo[begin];
        }

        // Try all the boxes after begin (including begin) as bottom
        // and, recursively, all the stacks that can be formed after bottom
        long mx = 0;
        int[] bottom = boxes[begin];
        long highest = 0;

        // find the tallest stack that can be formed on top of bottom
        for (int j=begin+1; j<boxes.length; j++){
            if ((boxes[j][0] < bottom[0]) && (boxes[j][1] < bottom[1])){
                // to be valid, a stack must be smaller in width and depth
                long h = highestStack(boxes, memo, j);
                highest = (highest > h) ? highest : h;
            }
        }
        highest += bottom[2];

        mx = (highest > mx) ? highest : mx;

        if (mx > memo[begin]){
            memo[begin] = mx;
        }
        return mx;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine().trim());
        int[][] boxes = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] split = in.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                boxes[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(highestStack(boxes));
        in.close();
    }
}
