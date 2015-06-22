package tree;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 * 
 * 
 * @author yunhe
 *
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)  return true;
        return dfs(root.left, root.right);
    }
    
    boolean dfs(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)  return true;
        if(leftNode == null || rightNode == null)  return false;
        if(leftNode.val != rightNode.val)  return false;
        if(dfs(leftNode.left, rightNode.right) == false)  return false;
        if(dfs(leftNode.right, rightNode.left) == false)  return false;
        return true;
    }
}
