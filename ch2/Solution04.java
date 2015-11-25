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
 * Partition a linked list around a value v.
 * If v is contained within the list, the values of v only need to
 * be after the elements less than v.
 */
public class Solution04 {
    public static void main(String[] args){
        Solution04 solution04 = new Solution04();
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(8);
        Node d = new Node(5);
        Node e = new Node(10);
        Node f = new Node(2);
        Node g = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        System.out.println("Original linked list: ");
        solution04.printList(a);
        Node partitioned = solution04.partition(a,5);
        System.out.println("Partitioned linked list: ");
        solution04.printList(partitioned);

    }

    /**
     * Partition a linked list around a value.
     * @param head - Head of the linked list
     * @param v - Value to partition around
     * @return head of the partitioned linked list
     */
    public Node partition(Node head, int v){
        if (head == null || head.next == null){
            return head;
        }

        // Elements smaller than v will be added at the new head
        // Elements greater or equal than v will be appended to the new tail
        Node newHead = head;
        Node newTail = newHead;

        Node current = head.next;
        Node next = current.next;
        newHead.next = null;
        current.next = null;

        while (current != null){
            if (current.val < v){
                current.next = newHead;
                newHead = current;
            }
            else{
                newTail.next = current;
                newTail = current;
            }
            current = next;
            if (current != null){
                next = current.next;
                current.next = null;
            }
        }

        return newHead;
    }

    /**
     * Helper function to print a linked list.
     * @param head - Head of the linked list to print
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
