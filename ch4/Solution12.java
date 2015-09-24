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
public class Solution12 {
    public static void main(String[] args){
        Solution12 solution12 = new Solution12();
        // tree1:
        //                   7
        //                 /   \
        //                3     -1

        TreeNode a1 = new TreeNode(7);
        TreeNode b1 = new TreeNode(3);
        TreeNode c1 = new TreeNode(-1);

        a1.left = b1;
        a1.right = c1;

        System.out.println("number of paths in tree1 summing to 10: " + solution12.numberOfPaths(a1,10));
        System.out.println("number of paths in tree1 summing to 6: " + solution12.numberOfPaths(a1,6));
        System.out.println("number of paths in tree1 summing to 1: " + solution12.numberOfPaths(a1,1));

        // tree2:
        //                        10
        //                      /    \
        //                     5      -3
        //                    / \       \
        //                   3   2       11
        //                  / \   \
        //                 3   -2  1

        TreeNode a2 = new TreeNode(10);
        TreeNode b2 = new TreeNode(5);
        TreeNode c2 = new TreeNode(-3);
        TreeNode d2 = new TreeNode(3);
        TreeNode e2 = new TreeNode(2);
        TreeNode f2 = new TreeNode(11);
        TreeNode g2 = new TreeNode(3);
        TreeNode h2 = new TreeNode(-2);
        TreeNode i2 = new TreeNode(1);

        a2.left = b2;
        a2.right = c2;
        b2.left = d2;
        b2.right = e2;
        c2.right = f2;
        d2.left = g2;
        d2.right = h2;
        e2.right = i2;

        System.out.println("\nnumber of paths in tree2 summing to 8: " + solution12.numberOfPaths(a2,8));


    }

    /**
     * Brute force solution....
     * @param root
     * @param target
     * @return
     */
    public int numberOfPaths(TreeNode root, int target){
        if (root.val == target){
            return 0;
        }
        return numberOfPathsFromNode(root, target) + numberOfPathsFromNode(root.left, target) + numberOfPathsFromNode(root.right, target);
    }

    public int numberOfPathsFromNode(TreeNode root, int target){
        if (root == null){
            return 0;
        }
        if (target == root.val){
            return 1;
        }
        return numberOfPathsFromNode(root.left, target-root.val) + numberOfPathsFromNode(root.right,target-root.val);
     }


}
