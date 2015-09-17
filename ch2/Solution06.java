import java.util.ArrayList;


//Problem: Implement a function to check if a linked list is a palindrome

class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}


public class Solution06 {

public boolean isPalindrome(Node head) {
        
		//If the head is null, we consider the result technically a palindrome
        if(head == null) return true;
        
        //We'll store the values of each successive node in an ArrayList
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        Node current = head;
        
        //We populate the ArrayList with the values of each successive node in the list
        while(current != null){
            array.add(current.data);
            current = current.next;
        }
        
        int arraySize = array.size();
        
        //Finally, we iterate through the array, checking if the first value equals the last value,
        //if the second value equals the second-to-last value, and so on.  If we find a point at which
        //this is not true, we return false immediately.  Otherwise, if we make it through the for loop,
        //we return true.
        for(int i=0; i<arraySize; i++){
            if(array.get(i) - array.get(arraySize - i - 1) != 0){
                return false;
            }
        }
        return true;
    }
}
