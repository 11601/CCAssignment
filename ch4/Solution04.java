import javax.transaction.TransactionRequiredException;

/**
 * Created by Hakim on 9/20/15.
 */

/**
 * Define a tree node.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v){
        val = v;
    }
}

/**
 * Check whether a binary tree is balanced.
 */
public class Solution04 {
    public static void main(String[] args){
        Solution04 solution04 = new Solution04();
        // Tree1 is not balanced:
        //          1
        //        /   \
        //      2       3
        //     /
        //    4
        //     \
        //      5
        TreeNode a1 = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode c1 = new TreeNode(3);
        TreeNode d1 = new TreeNode(4);
        TreeNode e1 = new TreeNode(5);

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        d1.right = e1;

        System.out.println("isBalanced(tree1): " + solution04.isBalanced(a1));

        // Tree2 is balanced:
        //          1
        //        /   \
        //      2       3
        //     / \
        //    4   5
        TreeNode a2 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode c2 = new TreeNode(3);
        TreeNode d2 = new TreeNode(4);
        TreeNode e2 = new TreeNode(5);

        a2.left = b2;
        a2.right = c2;
        b2.left = d2;
        b2.right = e2;

        System.out.println("isBalanced(tree2): " + solution04.isBalanced(a2));
    }

    /**
     * Check whether the binary tree rooted at root is balanced.
     * @param root - root of the tree
     * @return true if the tree is balanced. false otherwise
     */
    public boolean isBalanced(TreeNode root){
        int height = computeHeight(root);
        return height >= 0;
    }

    /**
     * Compute the height of a binary tree if it is balanced.
     * @param root - Root of the binary tree
     * @return Height of the tree if it is balanced. -1 if it isn't
     */
    public int computeHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        // If the left and right subtrees' height differ by more than 1
        // or if either of these subtrees is not balanced
        // then return -1
        int leftHeight = computeHeight(root.left);
        if (leftHeight < 0 ){
            return -1;
        }

        int rightHeight = computeHeight(root.right);
        if (rightHeight < 0){
            return -1;
        }

        if (Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        else{
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
