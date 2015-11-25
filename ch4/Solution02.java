/**
 * Created by Hakim on 9/19/15.
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
 * Create a BST with minimal height.
 */
public class Solution02 {
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();
        int[] sortedArray = {1,2,3,4,5,6,7,8};
        TreeNode root = solution02.buildMinimalTree(sortedArray, 0, sortedArray.length-1);

        System.out.println("Level 1: " + root.val);
        System.out.println("Level2: " + root.left.val + " | " + root.right.val);
        TreeNode b = root.left;
        TreeNode c = root.right;
        System.out.println("Level3: " + b.left.val + " | " + b.right.val + " | " + c.left.val + " | " + c.right.val);
        TreeNode g = c.right;
        System.out.println("Level4: " + g.right.val);
    }

    /**
     * Given a sorted array, create a BST with minimal height.
     * @param sortedArray
     * @param min
     * @param max
     * @return Root of the BST created.
     */
    public TreeNode buildMinimalTree(int[] sortedArray, int min, int max){
        // To create a BST with minimal height, we try to create a
        // BST as balanced as possible
        if (min > max){
            return null;
        }

        int middle = (min+max)/2;
        // middle element as root
        TreeNode root = new TreeNode(sortedArray[middle]);

        // recurse for left subtree
        root.left = buildMinimalTree(sortedArray, min, middle-1);
        // recurse for right subtree
        root.right = buildMinimalTree(sortedArray, middle+1, max);

        return root;
    }
}
