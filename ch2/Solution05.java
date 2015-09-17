
//Problem: You have two numbers represented by a linked list, where each node contains
//a single digit.  The digits are stored in reverse order, such that the 1's digit is
//at the head of the list.  Write a function that adds the two numbers and returns
//the sum as a linked list

//NOTE: I found this problem in LeetCode and solved it there.  I struggled at first,
//So I looked through the discussion forum, and studied a few solutions there.  I found
//one solution to be especially elegant, so I studied it the hardest, and I am sure my code
//resembles it.  That solution can be found here: https://leetcode.com/discuss/51516/java-recursion-solution
//I hope my comments in the code below will demonstrate that I understand the code that I have written

class Node{
	Node next;
	int data;
	
	public Node(int d){
		data = d;
	}



public class Solution05{
	
	//Create a method that takes the heads of the two lists as inputs,
	//Then call them in a helper method, with a carry value of 0, to do the brunt of the work
	public Node addTwoLists(Node l1, Node l2){
		return helper(l1, l2, 0);
	}
	
	public Node helper(Node l1, Node l2, int carry){
		
		//If we have reached the end of both lists, we check if our carry value is 1, i.e. if the final
		//two numbers we added summed to a value of 10 or greater.  If so, we must add a one to the end of
		//our solution, but appending a node with a value of one.  If not, we are done.
		if(l1 == null && l2 == null){
			if(carry == 1){
				return new Node(1);
			} else {
				return null;
			}
		}
		//We initialize sum, which will hold the sum of the numbers we add from the lists. We initialize it to
		//the value of carry, which will be zero if the last recursive step yielded a sum less than ten, or one otherwise.
		int sum = carry;
		
		//We add to values of l1 and l2 to sum, if l1 and l2 are not null, respectively (i.e. if we have not reached
		//the end of the first list or the second list of numbers, respectively)
		if(l1 != null) sum += l1.data;
		if(l2 != null) sum += l2.data;
		
		//We set the value of carry based on whether the sum calculated in the previous lines is greater than ten.
		//If it is, sum/10 will be 1; if not, it will be zero.
		carry = sum/10;
		
		//We mod sum by 10 to get the actual (single-digit) value that be assigned to the next node in our solution list.
		//Then we create that next node, called "more" below:
		sum %= 10;
		
		Node more = new Node(sum);
		
		//Finally, we check whether we have reached the end of either input list.  If so, we only step to the next
		//node in the input list for which we've not yet reached the end.  Otherwise, we step forward one node in both
		//input lists, recursing back through 'helper' with these updated nodes, to get the node that will come after "more".
		if(l1 == null || l2 == null){
			more.next = (l1 == null ? helper(l1, l2.next, carry) : helper(l1.next, l2, carry));
		} else {
			more.next = helper(l1.next, l2.next, carry);
		}
		return more;
	}
}
