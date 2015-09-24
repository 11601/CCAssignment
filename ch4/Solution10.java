/**
 * Created by Hakim on 9/22/15.
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
 * Check whether a tree is another's subtree.
 */
public class Solution10 {
    public static void main(String[] args){
        Solution10 solution10 = new Solution10();
        // tree1
        //              6
        //            /   \
        //           5     9
        //          / \
        //         3   1
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        // tree2 (is subtree of t1)
        //              5
        //             / \
        //            3   1
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(1);

        f.left = g;
        f.right = h;

        // tree3 (is not subtree of t1)
        //              5
        //             / \
        //            3   2

        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(3);
        TreeNode k = new TreeNode(2);

        i.left = j;
        i.right = k;

        System.out.println("Is tree2 a subtree of tree1: " + solution10.isSubtree(a,f));
        System.out.println("Is tree2 a subtree of tree1: " + solution10.isSubtree(a,i));

    }

    /**
     * Check whether t2 is a subtree of t1.
     * @param t1
     * @param t2
     * @return true if t2 is a subtree of t1. false otherwise
     */
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;    // empty tree is a subtree of any tree
        }
        if (t1 == null) {
            // we already checked that t2 is not null
            return false;
        }
        if (t1.val == t2.val){
            return isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right);
        }
        else{
            return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
        }
    }
}
