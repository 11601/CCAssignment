import java.util.Random;

/**
 * Created by Hakim on 10/6/15.
 */
public class Solution07 {
    public static void main(String[] args){
        Solution07 solution07 = new Solution07();
        String solution = "Each family has n boys and 1 girl.\n" +
                "The probability of having 0 boys and 1 girl is 1/2\n" +
                "More generally, the probability of having n boys and 1 girl is (1/2)^n (for having n boys first) * 1/2 = (1/2)^(n+1)\n" +
                "Let's compute the expected gender ratio: The ratio of girls over boys is:" +
                "Pr(having 1 girl given 0 boys) * (1/(0+1)) + ...+ Pr(having 1 girl given n boys) * (1/(n+1)) + ... \n" +
                "This gives: sum_{n=0,n=inf}((1/n+1)*(0.5^(n+1)))\n" +
                "We compute this probability for N=1000 families and find: " + solution07.prediction(1000) + "\n" +
                "Why does this result make sense?\n" +
                "Intuitively, the fact that each family has to have children until they have one girl " +
                "will make some families have different ratios of girls and boys. At the population level, however, " +
                "the probability of having a girl is still 0.5. Hence, at the populatino level, the gender ratio is " +
                "still 0.5.\n" +
                "We simulate this process with N=10, N=100, and N=1000 families:\n" +
                "N=10: " + solution07.simulation(10) + "\n" +
                "N=100: " + solution07.simulation(100) + "\n" +
                "N=1000: " + solution07.simulation(1000) + "\n";
        System.out.println(solution);
    }

    public double prediction(int n){
        double result = 0;

        for (int i=0; i<n; i++){
            result += (1/(i+1)) * Math.pow(0.5,i+1);
        }

        return result;
    }

    public double simulation(int numFamilies){
        Random random = new Random();
        double totalBoys = 0;
        double totalGirls = 0;
        double proportion = 0;
        for (int family=0; family<numFamilies; family++){
            int numBoys = 0;
            int numGirls = 0;

            while (numGirls < 1){
                if (random.nextBoolean()){
                    numGirls++;
                }
                else{
                    numBoys++;
                }
            }

            totalBoys += numBoys;
            totalGirls += numGirls;
        }

        return totalGirls/(totalBoys+totalGirls);
    }
}
