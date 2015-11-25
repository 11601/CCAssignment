/**
 * Created by Hakim on 9/21/15.
 */

/**
 *
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
 * Question 4.8
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        // Tree1:
        //                   1
        //                 /   \
        //                0     2
        //               / \   /
        //              3   4  5
        //             /     \
        //            8       6
        //                   /
        //                  7
        // First common ancestor of 8 and 7: 0

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(6);
        TreeNode i = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        d.left = g;
        e.right = h;
        h.left = i;

        TreeNode notInTree = new TreeNode(11);
        System.out.println("first common ancestor of 7 and 8: " +  solution08.firstCommonAncestor(a,g,i).val);
        System.out.println("first common ancestor of 7 and 5: " +  solution08.firstCommonAncestor(a,f,i).val);
        System.out.println("first common ancestor of notInTree and 5: " +  solution08.firstCommonAncestor(a,f,notInTree));

    }

    /**
     * Find the first common ancestor of two nodes in a binary tree.
     * @param root - root of the tree
     * @param a - first node
     * @param b - second node
     * @return first common ancestor if it exists. null otherwise
     */
    public TreeNode firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
        if (root == null || (root.left == null && root.right == null)){
            return null;
        }

        boolean leftDescendentA = isDescendent(root.left, a);
        boolean leftDescendentB = isDescendent(root.left, b);

        boolean rightDescendentA = isDescendent(root.right, a);
        boolean rightDescendentB = isDescendent(root.right, b);

        // if root has both a and b as descendents, but neither root.right nor root.left do, then root is the first common ancestor
        if (isDescendent(root, a) && isDescendent(root,b) && (!leftDescendentA || !leftDescendentB) && (!rightDescendentA || !rightDescendentB)){
            return root;
        }
        else if (leftDescendentA && leftDescendentB){
            return firstCommonAncestor(root.left, a, b);
        }
        else if (rightDescendentA && rightDescendentB){
            return firstCommonAncestor(root.right, a, b);
        }

        return null;
    }


    /**
     * Check whether a is in the subtree rooted in root.
     * @param root - root of the subtree
     * @param a - node for which existence is checked
     * @return - true if a is a descendant of root. false otherwise
     */
    public boolean isDescendent(TreeNode root, TreeNode a){
        if (root == null){
            return false;
        }

        if (root == a){
            return true;
        }

        return isDescendent(root.left, a) || isDescendent(root.right, a);
    }
}
