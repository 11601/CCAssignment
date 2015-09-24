
//Problem: write code to partition a linked list around a value x,
//such that all nodes less than x come before all nodes greater than
//or equal to x.  If x is contained within the list, the values of x
//only need to be after the elements less than x.

//NOTE: I had this solution committed to memory from studying the 5th edition
//of the textbook over the summer.  This is because I did not understand it for a long
//time, and I did it so many times that I finally just remembered the textbook solution.
//I tried but failed to come up with alternative solutions on my own, so I think
//I have some weaknesses with linked lists.  Just wanted to disclose this.

class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}


public class Solution04 {
	
	public Node partition(Node head, int a){
		
		//The strategy is to create two separate linked lists, and merge them at the end.
		//One list will hold nodes with values less than a, and the other will hold
		//nodes with values greater than or equal to a.  We initialize these lists with
		//the following nodes:
		
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		Node current = head;
		
		//We iterate through the given list until we reach the end (when current become null)
		while(current != null){
			
			//If the current node in the list is less than the partition value a,
			//We check to see if the "smaller" list is empty.  If it is, we add the current
			//node as the first node in the "smaller list".  If it isn't, we add the current
			//node to the end of the smaller list.
			if(current.data < a){
				if(beforeStart == null){
					beforeStart = current;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = current;
					beforeEnd = current;
				}
				
			//Here we have that the current node is greater than or equal to the partition value a,
			//so we'll add the node to the "bigger" list.  As with the "smaller" list, we check to see
			//if the list is empty; if it is, we add the current node as the first node in the "bigger"
			//list.  If not, we append the current node to the end of the "bigger" list.
			} else {
				if(afterStart == null){
					afterStart = current;
					afterEnd = afterStart;
				} else {
					afterEnd.next = current;
					afterEnd = current;
				}
			}
			//We step to the next node in the list to continue interating.
			current = current.next;
		}
		
		//If the "smaller" list is empty, we return the head of the "bigger" list.
		if(beforeStart == null) return afterStart;
		
		//Otherwise, we append the tail of the "smaller" list to the head of the "bigger" list...
		beforeEnd.next = afterStart;
		
		//And we return the head of the "smaller list", which, after the above merge, is now the head
		//of the full partitioned list
		return beforeStart;
	}
}
