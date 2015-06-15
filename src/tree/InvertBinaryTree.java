package tree;

import java.util.LinkedList;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InvertBinaryTree {
	
	// recursion version
    public TreeNode invertTree_rec(TreeNode root) {
        if(root == null)  return null;
        TreeNode temp = root.right;
        root.right = invertTree_rec(root.left);
        root.left = invertTree_rec(temp);
        return root;
    }
    
    // iteration version
    public TreeNode invertTree_itr(TreeNode root) {
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	while(queue.size() != 0){
    		TreeNode cur = queue.poll();
    		if(cur == null)  continue;
    		
    		// swap left and right child
        	TreeNode temp = cur.right;
        	cur.right = cur.left;
        	cur.left = temp;
        	
        	queue.offer(cur.left);
        	queue.offer(cur.right);
    	}
    	
    	return root;
    	
    }
}
