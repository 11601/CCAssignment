/**
 * Created by Hakim on 10/4/15.
 */

/**
 * 6.6.
 */
public class Solution06 {
    public static void main(String[] args){
        String solution = "Let's note p the number of blue eyed persons on the island.\n" +
                "If p==1: The blue eyed person will see that no one else has blue eyes. In addition to that, " +
                "he knows that at least one person is blue eyed. It must be him and he will leave on the first night.\n" +
                "If p==2: Both blue eyed persons will see that at least one other person has blue eyes. Either that " +
                "person is the only one, or they too are blue eyed. If the other person was the only one, then he " +
                "would leave the first night. Both blue eyed persons will the wait for the first night. On the second " +
                "day, when no one leaves, they will understand that the other person was expecting them to leave and " +
                "so they are both blue eyed. Finally, they will both leave on the second night.\n" +
                "Let's prove by induction that p blue eyed tourist will all leave on the pth day.\n" +
                "We just proved p=1 and p=2 and let's assume this property is true for up to p-1 blue eyed tourist.\n" +
                "When there are p blue eyed persons, each person will know that there are either " +
                "p-1 blue eyed persons (the others he can see) or p persons (the others + himself). " +
                "He will then wait at least p-1 nights, expecting all of them to leave that night. Since everyone " +
                "is expecting the same thing, no one will leave. On the pth night, they will understand there are " +
                "in fact p blue eyed persons and the p of them will leave.\n" +
                "In conclusion, if the island contains p blue eyed persons, then it takes p nights for " +
                "them to leave. (They will all leave on the pth night)";
    }
}
