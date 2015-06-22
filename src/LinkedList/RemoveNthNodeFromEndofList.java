package LinkedList;

/**
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.

 * 
 * @author yunhe
 *
 */
public class RemoveNthNodeFromEndofList {
	
	//  simple code
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)  return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode flag = dummy;
        ListNode cur = dummy;
        int len = 0;
        while(cur.next != null){
            cur = cur.next;
            if(++len > n)
                flag = flag.next;
        }
        flag.next = flag.next.next;
        return dummy.next;
    }
	
    //  complicated code
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        if(head == null){
        	return null;
        }else if(n == 0){
        	return head;
        }
        ListNode1 tail = head;
        int i = 1;
        while(i < n){
        	if(tail == null)  return head;
        	tail = tail.next;
        	i++;
        }
        ListNode1 pre;
        if(tail.next == null){
        	return head.next;
        }else{
        	tail = tail.next;
        	pre = head;
        }
        while(tail.next != null){
        	tail = tail.next;
        	pre = pre.next;
        }
        pre.next = pre.next.next;
        
        return head;
    }
}


class ListNode1 {
	int val;
	ListNode1 next;
	ListNode1(int x) {
		val = x;
        next = null;
    }
 }
 
