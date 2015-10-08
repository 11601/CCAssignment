/**
 * Created by Hakim on 10/6/15.
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        String solution = "Let's start by considering the case where only one egg remains (after the first egg " +
                "breaks):\n" +
                "In that case, we have no choice but to do a linear search from the highest 'safe' point we know of " +
                "after breaking the first egg.\n" +
                "One first idea would be to do some sort of dichotomy: throw the first egg from floor 50, if it " +
                "breaks, than the result if below, otherwise it is above that floor. The problem is that this " +
                "approach has a bad worst case situation (which we are trying to optimize): If the egg breaks after " +
                "the first drop, then we have to do linear search with the second egg all the way from the first " +
                "floor " +
                "and, if N=50, then we would have to do 51 drops.\n" +
                "Another approach would be to drop the eggs in regular intervals: Throw the first egg on the nth " +
                "floor, then the second on the 2*nth floor etc. After the egg breaks, we only have to do a linear " +
                "seach on n floors at most. If, for example, we take n=10 and the egg breaks after the first drop, " +
                "then we only have to do a linear search between the first and the 9th floor, we reduces the problem " +
                "to 10 drops. On the other hand, if the first egg breaks at floor 100, and if N=99, then we would " +
                "have 9 + 10 = 19 drops.\n" +
                "There is a big gap between the ideal case and the worst one. As we are trying to reduce the worst " +
                "case number of drops, we need to do load balancing so as to lose a little bit on the best/average " +
                "cases and win on the worst one. The worst case corresponds to the situation where we have to do " +
                "all the possible drops for the first egg before doing a linear search with the second egg. " +
                "Therefore, " +
                "the total number of drops is numDrops(egg1)+numDrops(egg2) where numDrops(egg1) takes its maximum " +
                "value and numDrops(egg2) is constant. We can 'load balance' this sum by making sure numDrops(egg2) " +
                "is smaller when numDrops(egg1) is higher. That is, we can decrease the maximum value that " +
                "numDrops(egg2) can take when we increase numDrops(egg1). Assuming we start by dropping egg1 at " +
                "floor M, we will then drop it at floor M-1, then M-2 etc. This way, numDrops(egg1)+numDrops(egg2) " +
                "will be constant = M.\n" +
                "What is the optimal value of N we can choose?\n" +
                "We need M + (M-1) + (M-2) + ... + 1 >= 100\n" +
                "<=> M*(M+1)/2 >= 100\n" +
                "Solving for this second order polynomial and choosing the root so that " +
                "the values above are positive, \n" +
                "<=> M>=13.6509...\n" +
                "As M is an integer, we choose M=14.\n" +
                "Hence, the solution optimizing the number of drops consists of \n" +
                "1/ Drop egg1 at floor 14" +
                "2/ While egg1 is not broken, drop it from a height increasing by interval - 1 at every iteration\n" +
                "3/ When egg1 breaks, do a linear search with egg2.\n" +
                "The worst case number of drops is then is then 14+1=15\n" +
                "We can find this result using dp:";

        System.out.println(solution);
        System.out.println(solution08.maxNumberOfDrops(100,2));
    }

    /**
     * Fin max number of drops needed to find 'breaking' floor in a building of numFloors using numEggs.
     * @param numFloors
     * @param numEggs
     * @return
     */
    public int maxNumberOfDrops(int numFloors, int numEggs){
        int[][] results = new int[numFloors+1][numEggs+1];

        // if no floors, then 0
        for (int i=0; i<numEggs+1; i++){
            results[0][i] = 0;
        }

        // if one floors, then 1
        for (int i=0; i<numEggs+1; i++){
            results[1][i] = 1;
        }

        // If one egg, do linear search
        for (int i=1; i<numFloors+1; i++){
            results[i][1] = i;
        }

        for (int egg=2; egg<numEggs+1; egg++){
            for (int floorNum=2; floorNum<numFloors+1; floorNum++){
                int mn = Integer.MAX_VALUE;
                for (int floor=1; floor<floorNum+1; floor++){
                    int current = 1 + Math.max(results[floor-1][egg-1], results[floorNum-floor][egg]);
                    if (current < mn){
                        mn = current;
                    }
                }
                results[floorNum][egg] = mn;
            }
        }

        return results[numFloors][numEggs];
    }
}
