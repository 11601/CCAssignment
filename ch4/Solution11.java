import java.util.Random;

/**
 * Created by Hakim on 9/23/15.
 */

/**
 * Define a Tree.
 */
class Tree {
    TreeNode root;

    public void deleteNode(TreeNode node){
        if (root == null){
            return;
        }
        TreeNode toDelete = root.findNode(node.val);

        toDelete.deleteNode();
    }

    public void insertNode(TreeNode node){
        if (root == null){
            root = node;
        }
        else{
            root.insertNode(node);
        }
    }

    public TreeNode getRandomNode(){
        Random random = new Random();
        int index = random.nextInt(getSize(root));
        return findITh(root, index);
    }

    public TreeNode findITh(TreeNode root, int index){
//        System.out.println("root.val " + root.val + " index " + index + " leftSize " + getSize(root.left));
        if (index == getSize(root.left)){
            return root;
        }
        else if (index < getSize(root.left)){
            return findITh(root.left, index);
        }
        else{
            return findITh(root.right, index-getSize(root.left)-1);
        }
    }

    public int getSize(TreeNode root){
        if (root == null){
            return 0;
        }
        else{
            return root.size;
        }
    }
}

/**
 * Define a TreeNode.
 */
class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    int size = 1;

    public TreeNode(int v){
        val = v;
    }

    public void insertNode(TreeNode node){
        if (node.val <= val){
            if (left != null){
                left.insertNode(node);
            }
            else{
                left = new TreeNode(node.val);
                left.parent = this;
            }
        }
        else{
            if (right != null){
                right.insertNode(node);
            }
            else{
                right = new TreeNode(node.val);
                right.parent = this;
            }
        }
        size++;
    }

    public TreeNode findNode(int v){
        if (val == v){
            return this;
        }
        else if (v <= val) {
            if (left != null) {
                return left.findNode(v);
            }
            else{
                return null;
            }
        }
        else {
            if (right != null) {
                return right.findNode(v);
            }
            else{
                return null;
            }
        }
    }

    public void deleteNode(){
        if (left == null && right == null){
            if (parent.left == this){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }
        else if (left == null && right != null){
            parent.right = right;
            this.right = null;
        }
        else if (left != null && right == null){
            parent.left = left;
            this.left = null;
        }
        else{
            // the current node has both a left and a right child
            // randomly choose to replace it with its successor or
            // its predecessor
            Random random = new Random();
            int chooseLeft = random.nextInt(2);
            if (chooseLeft == 0){
                // replace with the predecessor
                TreeNode predecessor = this.findPredecessor();
                this.replaceNode(predecessor);
            }
            else{
                // replace with the successor
                TreeNode successor = this.findSuccessor();
                this.replaceNode(successor);
            }
        }
        TreeNode p = parent;
        while (p != null){
            p.size --;
            p = p.parent;
        }
    }

    public void replaceNode(TreeNode replacement){
        this.val = replacement.val;
        replacement.deleteNode();
    }

    public TreeNode findPredecessor(){
        // this.left is assumed to be non null
        TreeNode currentLeft = this.left;
        while (currentLeft.right != null){
            currentLeft = currentLeft.right;
        }
        return currentLeft;
    }

    public TreeNode findSuccessor(){
        // this.right is assumed to be non null
        TreeNode currentRight = this.right;
        while (currentRight.left != null){
            currentRight = currentRight.left;
        }
        return currentRight;
    }

}

public class Solution11 {
    public static void main(String[] args){
        // build tree:
        //                      20
        //                    /     \
        //                   10      30
        //                  /  \       \
        //                 5    15      35
        //                / \     \
        //               3   7     17

        Tree tree = new Tree();
        tree.insertNode(new TreeNode(20));
        tree.insertNode(new TreeNode(10));
        tree.insertNode(new TreeNode(30));
        tree.insertNode(new TreeNode(5));
        tree.insertNode(new TreeNode(15));
        tree.insertNode(new TreeNode(35));
        tree.insertNode(new TreeNode(3));
        tree.insertNode(new TreeNode(7));
        tree.insertNode(new TreeNode(17));

        System.out.println("tree.root.size " + tree.root.size);
        System.out.println("deleting node : " + tree.root.right.val);
        tree.deleteNode(tree.root.right);
        System.out.println("new node at the right of root: " + tree.root.right.val);
        System.out.println("new tree size: " + tree.root.size);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
        System.out.println("Random node: " + tree.getRandomNode().val);
    }
}
