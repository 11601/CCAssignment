/**
 * Created by Hakim on 9/29/15.
 */

/**
 * Define a Tree.
 */
class Tree{
    TreeNode root;

    /**
     * Insert a new number into the Tree.
     * @param x
     */
    public void track(int x){
        if (root == null){
            root = new TreeNode(x);
        }
        else{
            root.track(new TreeNode(x));
        }
    }

    /**
     * Get rank of x in the Tree.
     * @param x
     * @return
     */
    public int getRankOfNumber(int x){
        if (root == null){
            return -1;
        }
        else{
            return root.getRankOfNumber(x);
        }
    }
}

/**
 * Define a TreeNode.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    int rank;

    public TreeNode(int v){
        val = v;
    }

    public void track(TreeNode x){
        if (x.val <= val){
            if (left == null){
                left = x;
            }
            else{
                left.track(x);
            }
            rank++;
        }
        else{
            if (right == null){
                right = x;
            }
            else{
                right.track(x);
            }
            x.rank = rank+1;
        }
    }

    public int getRankOfNumber(int x){
        if (val == x){
            return rank;
        }
        else if (x <= val){
            if (left == null){
                return -1;
            }
            else{
                return left.getRankOfNumber(x);
            }
        }
        else{
            if (right == null){
                return -1;
            }
            else{
                return right.getRankOfNumber(x);
            }
        }
    }
}

public class Solution10 {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.track(5);
        tree.track(1);
        tree.track(4);
        tree.track(4);
        tree.track(5);
        tree.track(9);
        tree.track(7);
        tree.track(13);
        tree.track(3);

        System.out.println(" rank of 1: " + tree.getRankOfNumber(1));
        System.out.println(" rank of 3: " + tree.getRankOfNumber(3));
        System.out.println(" rank of 4: " + tree.getRankOfNumber(4));
        System.out.println(" rank of 44: " + tree.getRankOfNumber(44));
    }



}
