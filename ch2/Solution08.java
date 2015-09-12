/**
 * Created by Hakim on 9/11/15.
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
 * Given a circular linked list, return the node at the beginning of the loop.
 */
public class Solution08 {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;

        
        System.out.println("loop: " + solution08.detectLoop(a).val);

    }

    /**
     * Return the Node at the beginning of a loopy linked list.
     * @param head - Head of the linked list
     * @return node where the loop begins. null if there is no such a node
     */
    public Node detectLoop(Node head){
        if (head == null || head.next == null){
            return head;
        }

        // Slow runner moves one node at a time
        // Fast runner moves two nodes at a time
        Node slow = head.next;
        Node fast = head.next.next;

        // if we denote by len the length of the list before the loop begins,
        // fast and slow will meet len mod (size of the loop) before the node where
        // the loop begins
        while (slow != fast){
            if (fast.next == null){
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // we then introduce a third node starting from head
        // third and slow will meet at the node where the loop begins
        Node third = head;
        while (third != slow){
            third = third.next;
            slow = slow.next;
        }

        return third;
    }
}
