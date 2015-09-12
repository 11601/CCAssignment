/**
 * Created by Hakim on 9/11/15.
 */

import java.util.Stack;

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
 * Check whether a linked list is a palindrome.
 */
public class Solution06 {
    public static void main(String[] args){
        Solution06 solution06 = new Solution06();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println("isPalindrome(");
        solution06.printList(a);
        System.out.println("):");
        System.out.println(solution06.isPalindrome(a));

        a = new Node(1);
        b = new Node(2);
        c = new Node(3);
        d = new Node(2);
        e = new Node(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println();

        System.out.println("isPalindrome(");
        solution06.printList(a);
        System.out.println("):");
        System.out.println(solution06.isPalindrome(a));


    }

    /**
     * Check whether a linked list is a palindrome.
     * @param head - Head of the linked list
     * @return - true if the linked list is a palindrome. False otherwise
     */
    public boolean isPalindrome(Node head){
        if (head == null || head.next == null){
            return true;
        }

        // stack will save the first half of the list
        Stack<Integer> stack = new Stack<>();

        // Put the first half of the list in the stack
        Node fast = head;
        Node slow = head;

        while (fast != null){
            stack.push(slow.val);
            if (fast.next == null){
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // Compare the second half of the list to the elements stacked
        while (slow != null){
            int elt = stack.pop();
            if (elt != slow.val){
                return false;
            }
            slow = slow.next;
        }

        return true;
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
