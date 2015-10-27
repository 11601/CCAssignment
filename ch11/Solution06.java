/**
 * Created by Hakim on 10/19/15.
 */
public class Solution06 {
    public static void main(String[] args) {
        String solution = "Need to clarify the system under test:\n" +
                "- Why? Withdraw cash, deposit cash, check balance\n" +
                "- Where? In the street\n" +
                "- How? Insert card, enter pin, proceed to operation\n" +
                "- When? Anytime\n" +
                "- Who? Customers with/without disabilities, businesses\n" +
                "Define the priorities:\n" +
                "- Security: Block if wrong pin entered multiple times or card reported stolen\n" +
                "- Reliability: Do not give more money or less than asked for/ available in account\n" +
                "- Accessibility for people with disabilities\n" +
                "Failure handling: If not enough cash in the machine, signal the bank and the user\n" +
                "For each of the use cases identified, create tests. Automatise when possible.";

        System.out.println(solution);
    }
}
