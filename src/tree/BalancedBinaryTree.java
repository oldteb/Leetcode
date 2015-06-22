package tree;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * 
 * @author yunhe
 *
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)  return true;
        if(dfs(root, 1) == -1)  return false;
        return true;
    }
    
    int dfs(TreeNode root, int lvl){
        if(root.left == null && root.right == null) return lvl;
        int leftH = root.left == null ? lvl : dfs(root.left, lvl+1);
        int rightH = root.right == null ? lvl : dfs(root.right, lvl+1);
        if(leftH == -1 || rightH == -1)  return -1;
        if(Math.abs(leftH-rightH) > 1)  return -1;
        return Math.max(leftH,rightH);
    }
}
