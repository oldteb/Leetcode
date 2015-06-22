package tree;

/**
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * 
 * @author yunhe
 *
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    
    boolean dfs(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)  return true;
        if(leftNode == null || rightNode == null)  return false;
        if(leftNode.val != rightNode.val)  return false;
        if(dfs(leftNode.left,rightNode.left) == false)  return false;
        if(dfs(leftNode.right,rightNode.right) == false)  return false;
        return true;
    }
}
