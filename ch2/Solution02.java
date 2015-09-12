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
 * Find the kth to last node of a list.
 */
public class Solution02 {
    public static void main(String[] args){
        Solution02 solution02 = new Solution02();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.print("1 to last element of ");
        solution02.printList(a);
        System.out.println("is: " + solution02.kthToLast(a,1).val);
    }

    /**
     * Return kth to last element of a linked list.
     * k=0 corresponds to the last element of the list
     * @param head - Head of the linked list
     * @param k
     * @return kth to last node of the list
     */
    public Node kthToLast(Node head, int k){
        Node fast = head;
        Node slow = head;

        // Set the fast pointer k nodes away from the slow one
        for (int i=0; i< k; i++){
            if (fast == null){
                return null;
            }
            else{
                fast = fast.next;
            }
        }

        // Move the fast and slow pointers one node at a time
        // until fast points to the last node
        // slow will then be pointing to the kth to last node
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * Helper function to print a linked list.
     * @param head - Head of the linked list to print
     * @return String representing the linked list
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
