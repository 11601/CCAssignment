/**
 * Created by Hakim on 9/20/15.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v){
        val = v;
    }
}

public class Solution05 {
    public static void main(String[] args){
        Solution05 solution05 = new Solution05();
        // Tree1 is a BST
        //               4
        //             /   \
        //            2     6
        //           / \   / \
        //          1   3 5   7
        //                     \
        //                      8
        TreeNode a1 = new TreeNode(4);
        TreeNode b1 = new TreeNode(2);
        TreeNode c1 = new TreeNode(6);
        TreeNode d1 = new TreeNode(1);
        TreeNode e1 = new TreeNode(3);
        TreeNode f1 = new TreeNode(5);
        TreeNode g1 = new TreeNode(7);
        TreeNode h1 = new TreeNode(8);

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.left = f1;
        c1.right = g1;
        g1.right = h1;

        System.out.println("solution05.isValid(a1): " + solution05.isValid(a1));

        // Tree2 is NOT a BST
        //               5
        //             /   \
        //            2     6
        //           / \   / \
        //          1   3 5   7
        //                     \
        //                      8
        TreeNode a2 = new TreeNode(5);
        TreeNode b2 = new TreeNode(2);
        TreeNode c2 = new TreeNode(6);
        TreeNode d2 = new TreeNode(1);
        TreeNode e2 = new TreeNode(3);
        TreeNode f2 = new TreeNode(5);
        TreeNode g2 = new TreeNode(7);
        TreeNode h2 = new TreeNode(8);

        a2.left = b2;
        a2.right = c2;
        b2.left = d2;
        b2.right = e2;
        c2.left = f2;
        c2.right = g2;
        g2.right = h2;

        System.out.println("solution05.isValid(a2): " + solution05.isValid(a2));
    }

    public boolean isValid(TreeNode root){
        // Assume left subtree nodes must be less or equal to root.val
        //        right subtree nodes must be greater than root.val
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, int min, int max){
        if (root == null){
            return true;
        }

        // Check that left nodes are smaller than min and greater than max
        // Check no overflow occurs on max value
        if (root.val > max || root.val < min || root.val == Integer.MAX_VALUE && root.right != null){
            return false;
        }

        // Check that left and right subtrees are valid
        return isValid(root.left, min, root.val) && isValid(root.right, root.val+1, max);
    }
}
