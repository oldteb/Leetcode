package LinkedList;

public class ReverseList {
	
	//  iteration version
    public ListNode reverseList(ListNode head) {
        if(head == null)  return null;
        ListNode dummy = new ListNode(0);
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
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
