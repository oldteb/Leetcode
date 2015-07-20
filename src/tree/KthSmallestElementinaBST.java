package tree;

import java.util.Stack;

/**
 * 
 * <P>Given a binary search tree, write a function kthSmallest
 *  to find the kth smallest element in it.
 * 
 * <P><strong>Note:</strong>
 * You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.
 * 
 * <P><strong>Follow up:</strong>
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * 
 * 
 * @author yunhe
 *
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)  return -1;;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        
        int count = 1;
        while(count < k){
            TreeNode cur = stack.pop();
            count++;
            temp = cur.right;
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
        }
        
        return stack.pop().val;
        
    }
}
