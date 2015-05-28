package LinkedList;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null){
            slow = slow.next;
            if(fast.next == null)  fast = null;
            else fast = fast.next.next;
            if(fast == slow)  break;
        }
        if(fast == null || slow == null)  return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
