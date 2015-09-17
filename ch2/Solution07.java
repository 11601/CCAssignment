import java.util.HashSet;


//Problem: Given two singly linked lists, determine if the two lists intersect.  Return the
//intersecting node.  Note that the intersection is defined based on reference, not value.
//That is, if the kth node of the first linked list is the exact same node (by reference)
//as the jth node of the second list, then they are intersecting.

//NOTE: I verified this solution by completing the same problem on LeetCode:
//https://leetcode.com/problems/intersection-of-two-linked-lists/


class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}
}


public class Solution07 {
    public Node getIntersectionNode(Node headA, Node headB) {
        
    	//Check for the null input case first
        if(headA == null && headB == null) return null;
        
        //Assign the starting nodes for traversing the two lists.
        Node currentA = headA;
        Node currentB = headB;
        
        //Create a HashSet to hold Nodes found so far from both lists. If at any point
        //we encounter a node that is already in the set, we return that node,
        //since it must be a point of intersection between the two lists.
        //This is the methodology in the while loop, below.
        HashSet<Node> set = new HashSet<Node>();
        
        while(currentA != null || currentB != null){
            if(currentA != null){
                if(set.contains(currentA)){
                    return currentA;
                } else if(!set.contains(currentA)){
                    set.add(currentA);
                    currentA = currentA.next;
                }    
            }
            if(currentB != null){
                if(set.contains(currentB)){
                    return currentB;
                } else if(!set.contains(currentB)){
                    set.add(currentB);
                    currentB = currentB.next;
                }
            }
        }
        //If we've found no point of intersection during the while loop, there isn't one,
        //so we return null
        return null;
    }
}
