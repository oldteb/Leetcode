package LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
        	return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
        	if(fast.next.next == null || slow.next == null){
        		return false;
        	}
        	else if(fast.next.next == slow.next){
        		return true;
        	}
        	fast = fast.next.next;
        	slow = slow.next;
        }
    	
    	
    	return false;
    }
}

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }
}