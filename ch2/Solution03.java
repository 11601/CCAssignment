
//Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node

class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}
}


public class Solution03 {

	public void deleteNode(Node x){
		
		if(x == null || x.next == null) return;
		
		//We proceed by setting x.data to x.next.data, then bypassing x.next, which achieves
		//the effect of deleting the argument node from the list:

		x.data = x.next.data;
		x.next = x.next.next;
		
	}
	
}
