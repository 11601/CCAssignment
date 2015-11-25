/**
 * Created by Hakim on 10/6/15.
 */

/**
 * 6.9.
 */
public class Solution09 {
    public static void main(String[] args){
        String solution = "The lockers that remain open after the last pass are those that " +
                "were toggled an odd number of time (since time 0 when they were all closed). " +
                "A locker is toggled at every pass that is a divisor of its order.\n" +
                "Therefore, the lockers that remain open are those that have an odd number of " +
                "divisors.\n" +
                "We don't need to count the actual number of divisors of each number (no general formula). " +
                "We just need to know whether a number has an odd number of divisors.\n" +
                "Consider a number n. Assume p divides n, then there exists q st " +
                "n = p*q. Hence, if p divides q, then so does q. Therefore, if p and q are distinct, " +
                "then we have an pair of divisors for n (even number). The only case where we don't " +
                "have a pair is when p=q. That case corresponds to a perfect square n.\n" +
                "From here, we see that the number of lockers that remain open is exactly the " +
                "number of perfect squares smaller than 100. These perfect squares are given by " +
                "1^2, 2^2, ..., 10^2. There are 10 of them.\n" +
                "In conclusion, 10 lockers remain open.";

        System.out.println(solution);
    }
}
