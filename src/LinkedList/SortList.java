package LinkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null)  return null;
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode head){
        if(head.next == null)  return head;
        ListNode mid = findMiddle(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left,right);
    }
    
    ListNode merge(ListNode left, ListNode right){
        ListNode newhead = null;
        ListNode newtail = null;
        ListNode temp = null;
        while(left != null && right != null){
            if(left.val < right.val){
                temp = left;
                left = left.next;
            }
            else{
                temp = right;
                right = right.next;
            }
            temp.next = null;
            if(newtail == null){
                newhead = temp;
                newtail = temp;
            }
            else{
                newtail.next = temp;
            }
        }
        if(left == null){
            temp = right;
        }
        else temp = left;
        newtail.next = temp; 
        return newhead;
    }
    
    ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(fast != null){
            slow = slow.next;
            pre = pre.next;
            fast = fast.next;
            if(fast != null)  fast = fast.next;
        }
        pre.next = null;
        return slow;
    }
    
    public static void main(String[] args) {
    	SortList sl = new SortList();
    	ListNode node0 = new ListNode(3);  
    	ListNode node1 = new ListNode(2);  node0.next = node1;
    	ListNode node2 = new ListNode(4);  node1.next = node2;
    	
    	ListNode rst = sl.sortList(node0);
	}
}
