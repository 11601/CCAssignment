/**
 * Created by Hakim on 10/19/15.
 */
public class Solution02 {
    public static void main(String[] args){
        String solution = "Programming errors that could be causing this crash:\n" +
                "- Problems inside the program itself:\n" +
                "\t* Random variables. Randomness can be introduced in the code using random number generators, " +
                "user input, use of 'references' like current time.\n" +
                "- Problems caused by the system:\n" +
                "\t* Running out of resources, like memory, heap space\n" +
                "- Problems caused by dependencies:\n" +
                "\t* Buggy dependencies that return random false results\n" +
                "\n" +
                "How to test each possible source of the crash:\n" +
                "- Problems inside the program itself: Look into the code and search for uninitialized variables, " +
                "and sources of randomness\n" +
                "- Problems caused by the system: Isolate the program by stopping any other program that " +
                "is not necessary. Monitor the resources usage during the execution of the program\n" +
                "- Problems caused by dependencies: Does the program have dependencies? If so, need to test the " +
                "expected output of each of these dependencies";

        System.out.println(solution);
    }
}
