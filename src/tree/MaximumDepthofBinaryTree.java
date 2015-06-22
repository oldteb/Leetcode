package tree;

/**
 * 
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * 
 * @author yunhe
 *
 */

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lvl = 1;
        return help(root,lvl);
    }
    
    int help(TreeNode root, int lvl){
        if(root.left == null && root.right == null)  return lvl;
        int d = 0;
        if(root.left != null){
            d = help(root.left, lvl+1);
        }
        if(root.right != null){
            d = Math.max(d, help(root.right,lvl+1));
        }
        return d;
    }
}
