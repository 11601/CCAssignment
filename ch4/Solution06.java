/**
 * Created by Hakim on 9/20/15.
 */
class TreeNode{
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v){
        val = v;
    }
}

public class Solution06 {
    public static void main(String[] args){
        Solution06 solution06 = new Solution06();
        // Tree:
        //               4
        //             /   \
        //            2     6
        //           / \   / \
        //          1   3 5   7
        //                     \
        //                      8
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;

        b.parent = a;
        c.parent = a;
        d.parent = b;
        e.parent = b;
        f.parent = c;
        g.parent = c;
        h.parent = g;


        System.out.println("successor of 1: " + solution06.successor(d).val);
        System.out.println("successor of 2: " + solution06.successor(b).val);
        System.out.println("successor of 3: " + solution06.successor(e).val);
        System.out.println("successor of 4: " + solution06.successor(a).val);
        System.out.println("successor of 5: " + solution06.successor(f).val);
        System.out.println("successor of 6: " + solution06.successor(c).val);
        System.out.println("successor of 7: " + solution06.successor(g).val);
        System.out.println("successor of 8: " + solution06.successor(h));

    }

    /**
     * Find in-order successor of node node.
     * @param node
     * @return in-order successor of node
     */
    public TreeNode successor(TreeNode node){
        if (node == null){
            return null;
        }

        if (node.right != null){
            return leftMost(node.right);
        }
        else{
            return nextParent(node);
        }
    }

    /**
     * Find the leftmost child of a node.
     * @param node - node for which the leftmost child is searched
     * @return leftmost child.
     */
    public TreeNode leftMost(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode current = node;
        while (current.left != null){
            current = current.left;
        }

        return current;
    }

    /**
     * Find the next parent in succession order.
     * This is the first parent for which the current node is its left child
     * @param node - Node for which the next parent is searched
     * @return next parent
     */
    public TreeNode nextParent(TreeNode node){
        if (node.parent == null){
            return null;
        }
        TreeNode current = node;

        while (current.parent.left != current){
            current = current.parent;
            if (current.parent == null){
                return null;
            }
        }
        return current.parent;
    }
}
