/**
 * Created by Hakim on 9/11/15.
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
 * Sum two numbers represented by linked lists.
 */
public class Solution05 {
    public static void main(String[] args){
        Solution05 solution05 = new Solution05();
        Node a = new Node(7);
        Node b = new Node(1);
        Node c = new Node(6);

        Node d = new Node(5);
        Node e = new Node(9);
        Node f = new Node(2);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        System.out.println("Backwards: ");
        solution05.printList(a);
        System.out.println(" + ");
        solution05.printList(d);
        System.out.println(" = ");
        solution05.printList(solution05.sumLists(a,d));

        System.out.println();

        System.out.println("Forwards: ");
        solution05.printList(a);
        System.out.println(" + ");
        solution05.printList(d);
        System.out.println(" = ");
        solution05.printList(solution05.sumListsForwardOrder(a, d));
    }

    /**
     * Sum two numbers represented by linked lists where the digits are stored in reverse order.
     * @param a - Head of the first linked list
     * @param b - Head of the second linked list
     * @return Head of the linked list representing the summed number
     */
    public Node sumLists(Node a, Node b){
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }

        // Dummy node to start the linked list
        Node dummy = new Node(Integer.MIN_VALUE);
        Node next = dummy;

        int carry = 0;

        // Sum each node from the lists
        while (a != null || b != null){
            int aVal = (a != null) ? a.val : 0;
            int bVal = (b != null) ? b.val : 0;

            int sum = aVal + bVal + carry;
            int v = sum % 10;

            Node current = new Node(v);
            next.next = current;
            next = current;

            carry = (sum >= 10) ? 1 : 0;

            a = a.next;
            b = b.next;
        }

        // if remainder == 1, add extra node
        if (carry == 1){
            Node current = new Node(1);
            next.next = current;
        }

        return dummy.next;
    }

    /**
     * FOLLOW UP: Sum two numbers represented by linked lists where the digits are stored in FORWARD order.
     * @param a - Head of the first linked list
     * @param b - Head of the second linked list
     * @return Head of the linked list representing the sum
     */
    public Node sumListsForwardOrder(Node a, Node b){
        // Count the number of nodes in each list
        int n1 = numberNodes(a);
        int n2 = numberNodes(b);

        // Complete the smallest list with zeros on its left
        if (n1 < n2){
            a = completeList(a, n2-n1);
        }
        else if (n1 > n2){
            b = completeList(b, n1-n2);
        }

        Node result = sumRecursive(a, b);
        // The head returned by sumRecursive might be greater than 10
        // In that situation, create a new head set to 1 and
        // set the previous head to its value minus 10
        if (result.val >= 10){
            Node head = new Node(1);
            result.val -= 10;
            head.next = result;
            return head;
        }
        else {
            return result;
        }
    }

    /**
     * Recursive function used to sum a linked list forward.
     * Warning: The head of the created linked list might be greater than 10 and this case
     * must be handled in the caller
     * @param node1 - current node of list1 being summed
     * @param node2 - current node of list2 being summed
     * @return Node corresponding to the sum of node1 and node2
     */
    public Node sumRecursive(Node node1, Node node2){
        // The input linked lists have same size
        if (node1 == null && node2 == null){
            return null;
        }

        // Compute the sum of the number formed by the digits to the right of node1 and node2
        Node next = sumRecursive(node1.next, node2.next);

        int sum = node1.val + node2.val;
        if (next != null){
            int carry = 0;
            if (next.val >= 10){
                // if the node on the right of the sum is greater than 10, then set carry to 1 and
                // replace this node by its actual value
                carry = 1;
                next.val -= 10;
            }

            sum += carry;
        }

        Node current = new Node(sum);
        current.next = next;

        return current;
    }

    /**
     * Helper function to complete a linked list by adding n zero nodes at its head.
     * @param a - Head of the linked list to complete
     * @param n - Number of zeros to add at the beginning
     * @return Head of the completed linked list
     */
    public Node completeList(Node a, int n){
        if (n == 0){
            return a;
        }

        Node head = new Node(0);
        Node node = head;

        for (int i=1; i<n; i++){
            Node current = new Node(0);
            node.next = current;
            node = node.next;
        }

        node.next = a;

        return head;
    }

    /**
     * Helper function counting the number of nodes in a linked list.
     * @param a - Head of the linked list
     * @return number of nodes in the linked list - int
     */
    public int numberNodes(Node a){
        if (a == null){
            return 0;
        }

        int result = 0;

        while (a != null){
            result++;
            a = a.next;
        }

        return result;
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
