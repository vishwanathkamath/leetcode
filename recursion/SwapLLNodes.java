import java.awt.List;

/*
To showcase the above guidelines, we give another example on how to solve a problem recursively. 

Given a linked list, swap every two adjacent nodes and return its head.

e.g.  for a list 1-> 2 -> 3 -> 4, one should return the head of list as 2 -> 1 -> 4 -> 3.

We define the function to implement as swap(head), where the input parameter head refers to the head of a linked list. The function should return the head of the new linked list that has any adjacent nodes swapped.

Following the guidelines we lay out above, we can implement the function as follows:

First, we swap the first two nodes in the list, i.e. head and head.next;
Then, we call the function self as swap(head.next.next) to swap the rest of the list following the first two nodes.
Finally, we attach the returned head of the sub-list in step (2) with the two nodes swapped in step (1) to form a new linked list.
As an exercise, you can try to implement the solution using the steps we provided above. Click on "Swap Nodes in Pairs" to try to implement the solution yourself.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapLLNodes {
    public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode Fhead = new ListNode(0);
		Fhead.next = head;
		ListNode p = Fhead;
		
		while(p.next != null && p.next.next != null) {
			ListNode LN1 = p;
			p = p.next;
			LN1.next = p.next;
			
			ListNode LN2 = p.next.next;
			p.next.next = p;
			p.next = LN2;
		}
    	
    	return Fhead.next;
    }
    
    class ListNode{
    	int val;
    	ListNode next;
    	ListNode(int x){
    		val = x;
    		this.next = null;
    	}
    }
}



/*
public ListNode swapPairs(ListNode head) {
    if(head==null || head.next==null)
        return head;
 
    //a fake head
    ListNode h = new ListNode(0);
    h.next = head;
 
    ListNode p1 = head;
    ListNode p2 = head.next;
 
    ListNode pre = h;
    while(p1!=null && p2!=null){
        pre.next = p2;
 
        ListNode t = p2.next;
        p2.next = p1;
        pre = p1;
        p1.next = t;
 
        p1 = p1.next;
 
        if(t!=null)
            p2 = t.next;
    }
 
    return h.next;
}

*/