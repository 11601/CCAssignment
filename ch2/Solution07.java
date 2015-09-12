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
 * Find the intersection of two linked lists.
 */
public class Solution07 {
    public static void main(String[] args){
        Solution07 solution07 = new Solution07();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.next = b;
        b.next = c;

        f.next = g;
        g.next = h;
        h.next = c;

        c.next = d;
        d.next = e;


        System.out.println("Intersection of ");
        solution07.printList(a);
        System.out.println(" and ");
        solution07.printList(f);
        System.out.println(": ");
        System.out.println(solution07.intersection(a,f).val);
    }

    /**
     * Find the intersection of two linked lists.
     * @param a - Head of the first linked list
     * @param b - Head of the second linked list
     * @return Node where the two linked lists intersect. Null if there is no such a node
     */
    public Node intersection(Node a, Node b){
        int count1 = 0;
        int count2 = 0;

        Node node1 = a;
        Node node2 = b;

        Node fast;
        Node slow;

        // Count the sizes of the two linked lists
        while (node1 != null){
            node1 = node1.next;
            count1++;
        }

        while (node2 != null){
            node2 = node2.next;
            count2++;
        }

        // Set the pointer of the longest list "its size - smallest list's size"
        // in advance so that, when we move this pointer at the same pace
        // as the pointer in the smallest list, they will meet at the node where
        // they intersect if such a node exists
        if (count1 > count2){
            int diff = count1 - count2;
            fast = a;
            for (int i=0; i<diff; i++){
                fast = fast.next;
            }
            slow = b;
        }
        else{
            int diff = count2 - count1;
            fast = b;
            for (int i=0; i<diff; i++){
                fast = fast.next;
            }
            slow = a;
        }

        while (fast != slow){
            // no intersection
            if (fast == null){
                return null;
            }

            fast = fast.next;
            slow = slow.next;
        }

        // fast and slow meet at the intersection node
        return fast;
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
