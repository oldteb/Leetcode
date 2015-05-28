package LinkedList;

public class RemoveNthNodeFromEndofList {
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
 
