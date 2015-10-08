/**
 * Created by Hakim on 10/4/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 6.1.
 */
public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();

        List<List<Double>> bottles = new ArrayList<>();
        List<Double> standard = new ArrayList<>();
        for (int i=0; i<123; i++){
            standard.add(1.0);
        }

        List<Double> heavy = new ArrayList<>();
        for (int i=0; i<13; i++){
            heavy.add(1.1);
        }

        for (int i=0; i<5; i++){
           bottles.add(new ArrayList(standard));
        }

        bottles.add(new ArrayList(heavy));

        for (int i=6; i<20; i++){
           bottles.add(new ArrayList(standard));
        }

        System.out.println("Heavy bottle (expect 5): " + solution01.findHeavyPills(bottles));
    }

    /**
     * Find the bottle that contains pills of 1.1 grams instead of 1 gram
     * @param bottles: List of the list of pills weights in each bottle
     * @return
     */
    public int findHeavyPills(List<List<Double>> bottles){
        // Given that we are only allowed to use the scale once, we are going to take pills from
        // all the bottles.
        // We assume that at least one bottle has 1 pill, one has a minimum of 2 pills etc
        // We take 1 pill from the first bottle
        //         2 pills from the second bottle
        //          ...
        //         20 pills from the last bottle
        // If all the pills had the same weight, then the total weight would be
        // 20 * 21/2 = 210 g
        // If bottle n contains the pills that weight 1.1 gram, then the weight excess
        // will be nE-1 grams.
        // Therefore, the bottle that contains the heavy pills is bottle n such that
        // weight = 210 + nE-1 => n = 10 * (weight - 210)

        double weight = 0;
        int len = bottles.size();
        for (int i=0; i<len; i++){
            weight += (i+1) * bottles.get(i).get(0);
        }

        return (int) (10*(weight - len*(len+1)/2));
    }
}
