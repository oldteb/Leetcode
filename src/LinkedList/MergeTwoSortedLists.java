package LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null)  return l1;
        else if(l1 == null)  return l2;
        ListNode head = null, tail = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                if(head == null){
                    head = p1;  tail = p1;
                }
                else{
                    tail.next = p1;
                    tail = tail.next;
                }
                p1 = p1.next;
            }
            else{
                if(head == null){
                    head = p2;  tail = p2;
                }
                else{
                    tail.next = p2;
                    tail = tail.next;
                }
                p2 = p2.next;
            }
        }
        
        if(p1 == null){
            tail.next = p2;
        }
        else{
            tail.next = p1;
        }
        
        return head;
        
    }
}
