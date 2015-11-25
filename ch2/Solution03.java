/**
 * Created by Hakim on 9/10/15.
 */

/**
 * Define a LinkedListNode.
 */
class Node{
    Node next;
    int val;

    public Node(int v){
        val = v;
    }
}

/**
 * Delete middle node of a linked list.
 */
public class Solution03 {
    public static void main(String[] args){
        Solution03 solution03 = new Solution03();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println("Before deleting middle node: ");
        solution03.printList(a);
        solution03.deleteMiddleNode(c);
        System.out.println("After deleting middle node: ");
        solution03.printList(a);
    }

    /**
     * Delete the middle node of a linked list given only this node.
     * @param middle - Middle node to delete
     */
    public void deleteMiddleNode(Node middle){
        if (middle == null){
            return;
        }

        // For each node starting from the middle node,
        // copy the value and next node of the node to come
        while (middle.next != null){
            middle.val = middle.next.val;
            middle.next = middle.next.next;
            middle = middle.next;
        }
    }

    /**
     * Helper function to create a String corresponding to a linked list.
     * @param head - Head of the linked list to print
     * @return String corresponding to that linked list
     */
    public void printList(Node head){
        if (head == null){
            System.out.println("");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(head.val);

        while (head.next != null){
            sb.append("->");
            sb.append(head.next.val);
            head = head.next;
        }

        System.out.println(sb.toString());
    }
}
