import java.util.HashSet;
import java.util.LinkedList;


//Problem: Remove duplicates from an unsorted linked list



class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}
}

public class Solution01 {

	//We assume we are given the head node of the list
	public void removeDuplicates(Node x){
		
		//Check for the null argument case.
		if(x == null) return;
		
		//Create a HashSet to store values encountered in traversing the list.
		//If we come to a node with a duplicate value, we will delete it
		HashSet<Integer> set = new HashSet<Integer>();
		
		//We create a Node, prev, that will allow us to delete a duplicate when we find one,
		//By setting prev.next to point to x.next (bypassing x, the current node)
		Node prev = null;
		
		//We iterate through the list, starting with the head (x).
		//If we find a duplicate, we delete it.  Otherwise, if we encounter a node
		//with a new value, we add it to our set
		while(x != null){
			if(set.contains(x.data)){
				prev.next = x.next;
			} else {
				set.add(x.data);
				prev = x;
			}
			x = x.next;
		}
	}
}
