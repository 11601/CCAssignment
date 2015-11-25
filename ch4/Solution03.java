/**
 * Created by Hakim on 9/19/15.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Define a TreeNode
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
 * Given a Binary Tree, create a linked list of all the nodes at each depth.
 */
public class Solution03 {
    public static void main(String[] args){
        Solution03 solution03 = new Solution03();

        // Define tree {1,2,3,null,null,4,5,null,null,6}
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        e.left = f;

        List<LinkedList<TreeNode>> result = solution03.buildListDepths(a);
        for (int i=0; i<result.size(); i++){
            System.out.print("level " + i + ": ");
            solution03.printLinkedList(result.get(i));
        }
    }

    /**
     * Create a list containing the linked lists for each level of a binary tree.
     * @param root - Root of the binary tree
     * @return List of all the linked lists
     */
    public List<LinkedList<TreeNode>> buildListDepths(TreeNode root){
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        // We implement a variant of BFS where instead of
        // using one queue, we use two and store the queues (linked lists here)
        // in the result for each level
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.add(root);
        result.add((LinkedList<TreeNode>)current.clone());

        while (!current.isEmpty()){
            // Move to the next level
            for (TreeNode t:current){
                if (t.left != null){
                    next.add(t.left);
                }
                if (t.right != null){
                    next.add(t.right);
                }
            }
            current.clear();
            if (!next.isEmpty()){
                result.add((LinkedList<TreeNode>)next.clone());
            }

            for (TreeNode t:next){
                if (t.left != null){
                    current.add(t.left);
                }
                if (t.right != null){
                    current.add(t.right);
                }
            }
            next.clear();
            if (!current.isEmpty()){
                result.add((LinkedList<TreeNode>)current.clone());
            }
        }

        return result;
    }

    /**
     * Helper method to print a linked list.
     * @param l
     */
    public void printLinkedList(LinkedList<TreeNode> l){
        if (l == null){
            System.out.println("");
            return;
        }

        for (int i=0;i<l.size()-1;i++){
            System.out.print(l.get(i).val + "->");
        }
        System.out.println(l.get(l.size() - 1).val);
    }
}
