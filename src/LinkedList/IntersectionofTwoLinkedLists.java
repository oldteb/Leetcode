package LinkedList;

/**
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 *
 * For example, the following two linked lists:
 *
 * A:          a1 ¡ú a2
 *                  ¨K
 *                     c1 ¡ú c2 ¡ú c3
 *                   ¨J            
 * B:     b1 ¡ú b2 ¡ú b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 * 
 * @author yunhe
 *
 */
public class IntersectionofTwoLinkedLists {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)  return null;
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while(curA != null){
            curA = curA.next;
            lenA++;
        }
        while(curB != null){
            curB = curB.next;
            lenB++;
        }
        if(lenA > lenB){
            curA = headA;
            curB = headB;
        }
        else{
            curA = headB;
            curB = headA;
        }
        
        for(int i = 0; i < Math.max(lenA,lenB) - Math.min(lenA,lenB); i++){
            curA = curA.next;
        }
        while(curA != null && curB != null){
            if(curA == curB)  return curA;
            curA = curA.next;
            curB = curB.next;
        }
        
        return null;
    }
}
