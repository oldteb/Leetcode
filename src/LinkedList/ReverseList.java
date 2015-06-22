package LinkedList;

public class ReverseList {
	
	//  iteration version
     public ListNode reverseList1(ListNode head) {
         ListNode dummy1 = new ListNode(0);
         ListNode dummy2 = new ListNode(0);
         dummy1.next = head;
         ListNode temp;
         while(dummy1.next != null){
             temp = dummy1.next;
             dummy1.next = temp.next;
             temp.next = dummy2.next;
             dummy2.next = temp;
         }
         return dummy2.next;
     }
    
    //  recursion version
    public ListNode reverseList2(ListNode head) {
        if(head == null)  return null;
        return (ListNode)(reverseList_rec(head)).head;
    }
    
    Tuple<ListNode, ListNode> reverseList_rec(ListNode head){
        ListNode newhead = head, newtail = head;
        if(head.next != null){
            Tuple<ListNode, ListNode> t = reverseList_rec(head.next);
            newhead = t.head;
            t.tail.next = head;
            head.next = null;
            newtail = head;
        }
        return new Tuple<ListNode, ListNode>(newhead, newtail);

    }
    
    public class Tuple<X, Y> { 
        public final X head; 
        public final Y tail; 
        public Tuple(X x, Y y) { 
            this.head = x; 
            this.tail = y; 
        } 
    }
}
