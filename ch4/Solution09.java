import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hakim on 9/22/15.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v){
        val = v;
    }
}

public class Solution09 {
    public static void main(String[] args){
        Solution09 solution09 = new Solution09();
        // tree
        //              2
        //             / \
        //            1   3
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;
        System.out.println(solution09.bstSequences(a).get(0));
        System.out.println(solution09.bstSequences(a).get(1));
    }

    public List<LinkedList<Integer>> bstSequences(TreeNode root){
        List<LinkedList<Integer>> result = new ArrayList<>();
        LinkedList<Integer> prefix = new LinkedList<>();
        if (root == null){
            result.add(new LinkedList<Integer>());
            return result;
        }

        prefix.add(root.val);
        List<LinkedList<Integer>> leftResult = bstSequences(root.left);
        List<LinkedList<Integer>> rightResult = bstSequences(root.right);

        // merge the left and right results so that the order in each element
        // in the left and right linked lists remain in relative order
        mergeResults(leftResult, rightResult, result, prefix);

        return result;
    }

    public void mergeResults(List<LinkedList<Integer>> leftResult, List<LinkedList<Integer>> rightResult, List<LinkedList<Integer>> result, LinkedList<Integer> prefix){
        for (LinkedList<Integer> lResult : leftResult){
            for (LinkedList<Integer> rResult : rightResult){
                weave(lResult, rResult, result, prefix);
            }
        }
    }

    public void weave(LinkedList<Integer> lResult, LinkedList<Integer> rResult, List<LinkedList<Integer>> result, LinkedList<Integer> prefix){
//        System.out.println("weaving " + lResult + " and " + rResult + " with prefix " + prefix);
        if (lResult.isEmpty()){
            LinkedList<Integer> currentResult = (LinkedList<Integer>) prefix.clone();
            currentResult.addAll(rResult);
            result.add(currentResult);
            return;
        }
        if (rResult.isEmpty()){
            LinkedList<Integer> currentResult = (LinkedList<Integer>) prefix.clone();
            currentResult.addAll(lResult);
            result.add(currentResult);
            return;
        }

        int lHead = lResult.remove();
        prefix.addLast(lHead);
        weave(lResult, rResult, result, prefix);
        lResult.add(lHead);
        prefix.removeLast();

        int rHead = rResult.remove();
        prefix.addLast(rHead);
        weave(lResult, rResult, result, prefix);
        rResult.add(rHead);
        prefix.removeLast();
    }
}
