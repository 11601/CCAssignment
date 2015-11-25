/**
 * Created by Hakim on 10/19/15.
 */
public class Solution04 {
    public static void main(String[] args) {
        String solution = "We want to test the webpage under two circonstances:\n" +
                "- High number of users trying to access it\n" +
                "- Sharp changes in the number of users trying to access it\n" +
                "For each of these scenarios, we might be interested in parameters like the response time " +
                "or the throughput.\n" +
                "We can load test the webpage by creating virtual users, each represented by " +
                "a program thread. To simulate a high number of users trying to access the webpage, " +
                "we can make a high number of threads try to access this webpage and measure, for " +
                "each user, the scores we defined earlier.\n" +
                "To test the reaction of the webpage under sharp changes in the number of users, we can" +
                " increase/decrease the number of threads trying to access the webpage simultaneously and " +
                "measure the same scores.";

        System.out.println(solution);
    }

}
