class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}
}


//Problem: Implement an algorithm to find the kth to last element of a singly linked list


public class Solution02 {
	
	//For this method, we take the value of k to be the number of nodes from the last node,
	//i.e. a value of 1 would mean 1 node from the end, and a value of 0 would be the last node in the list.
	public Node kthToLast(Node head, int k){
		
		if(head == null) return null;
		
		Node front = head;
		Node back = head;
		
		//We move Node front k nodes into the list
		for(int i=0; i<k; i++){
			if(front == null) return null;
			front = front.next;
		}
		
		//Now we move front and back at the same pace through the list,
		//until front hits the end of the list (i.e. is null). At that point,
		//Node back will be k nodes from the end of the list, so we return that node.
		while(front != null){
			front = front.next;
			back = back.next;
		}
		return back;
	}
	
}
