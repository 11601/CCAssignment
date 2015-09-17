import java.util.HashSet;


//Problem: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

//Note: I think my code is slower than the optimal solution, but it's extremely simple.
//Would this simplicity make up for the slow run time in an interview?  I know the traditional
//Approach to solving this problem is to use to "runners", but that seems so much more complex...
//(I solved this problem on LeetCode, so I know my solution works)

class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}
}


public class Solution08 {
    public Node detectCycle(Node head) {
        
        if(head == null) return null;
        
        //We simply create a HashSet that holds Node objects, and iterate through
        //the input list until we come across a node that's already in the set- the
        //start of the cycle.  If at any point current becomes null, that means we've
        //hit the end of the input list without finding a cycle, so we return null.
        HashSet<Node> set = new HashSet<Node>();
        
        Node current = head;
        
        while(current != null){
            if(set.contains(current)){
                return current;
            } else {
                set.add(current);
                current = current.next;
            }
        }
        return null;
    }
}
