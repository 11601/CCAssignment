import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hakim on 9/9/15.
 * Q2.1
 */

/**
 * Define a Linked List Node.
 */
class Node{
    Node next;
    int val;

    public Node(int v){
        val = v;
    }
}

/**
 * Remove duplicates in an unsorted Linked List.
 */
public class Solution01 {
    public static void main(String[] args){
        Solution01 solution01 = new Solution01();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(1);
        Node d = new Node(3);

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Before: ");
        solution01.printList(a);

        solution01.removeDuplicates(a);
        System.out.println("After removeDuplicates: ");
        solution01.printList(a);

        // Redefining the linked list with duplicates
        a = new Node(1);
        b = new Node(2);
        c = new Node(1);
        d = new Node(3);

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Before: ");
        solution01.printList(a);

        solution01.removeDuplicatesNoBuffer(a);
        System.out.println("After removeDuplicatesNoBuffer: ");
        solution01.printList(a);

    }

    /**
     * Remove duplicates in an unsorted linked list.
     * @param head - head of the linked list to remove duplicates from
     * @return head of the linked list from which duplicates were removed
     */
   public Node removeDuplicates(Node head){
       if (head == null || head.next == null){
           return head;
       }

       // Save the elements that were already seen
       Set<Integer> seen = new HashSet<>();

       Node current = head;
       seen.add(head.val);

       // For each node, if its content is saved in seen, remove it
       while (current.next != null){
           if (seen.contains(current.next.val)){
                current.next = current.next.next;
           }
           else{
               seen.add(current.next.val);
               current = current.next;
           }
       }
       return head;
   }

    /**
     * Remove duplicates in a linked list with no buffer allowed.
     * @param head - Head of the linked list to remove duplicates from
     * @return head of the linked list from which duplicates were removed
     */
    public Node removeDuplicatesNoBuffer(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node current = head;

        // For each node, loop through all the next nodes and remove them if they have the same value as
        // the current node
        while (current.next != null){
            Node n = current;
            while (n.next != null){
                if (n.next.val == current.val){
                    n.next = n.next.next;
                }
                else{
                    n = n.next;
                }
            }
            current = current.next;
        }
        return head;
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
