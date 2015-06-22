package LinkedList;

/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author yunhe
 *
 */
public class MergeTwoSortedLists {
	
	// use dummy to simplify appending node to tail of linklist
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode newtail = dummy, temp;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                temp = cur1;
                cur1 = cur1.next;
            }
            else{
                temp = cur2;
                cur2 = cur2.next;
            }
            temp.next = null;
            newtail.next = temp;
            newtail = newtail.next;
        }
        if(cur1 != null)  newtail.next = cur1;
        else if(cur2 != null)  newtail.next = cur2;
        
        return dummy.next;
    }
    
    // Complicated code
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
