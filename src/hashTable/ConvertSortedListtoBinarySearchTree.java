package hashTable;

public class ConvertSortedListtoBinarySearchTree {
	static ListNode h;
	 
	public TreeNode_tyh sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public TreeNode_tyh sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode_tyh left = sortedListToBST(start, mid - 1);
		TreeNode_tyh root = new TreeNode_tyh(h.val);
		h = h.next;
		TreeNode_tyh right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
	
	void printTree(TreeNode_tyh root){
		if(root == null){
			return;
		}
		
		if(root.left != null){
			printTree(root.left);
		}
		System.out.println(root.val);
		if(root.right != null){
			printTree(root.right);
		}
	}
	
	public static void main(String argv[]){
		ConvertSortedListtoBinarySearchTree t = new ConvertSortedListtoBinarySearchTree();
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(3);
		ListNode ln3 = new ListNode(4);
		ListNode ln4 = new ListNode(5);
		ListNode ln5 = new ListNode(7);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		
		TreeNode_tyh tn = t.sortedListToBST(ln1);
		t.printTree(tn);
		
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}


//Definition for binary tree
class TreeNode_tyh {
	int val;
	TreeNode_tyh left;
	TreeNode_tyh right;
	TreeNode_tyh(int x) { val = x; }
}
