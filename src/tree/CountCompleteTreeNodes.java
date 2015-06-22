package tree;

/**
 * 
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * 
 * 
 * @author yunhe
 *
 */


public class CountCompleteTreeNodes {
	
	// naive dfs solution : O(n) time complexity
    public int countNodes1(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
    
    // efficient O(lgn) time complexity
    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        int countLeft = nodeDepth(root,1);
        int countRight = nodeDepth(root,2);

        if(countLeft == countRight){
            // perfect binary tree
            return (1<<countLeft) - 1;
        }
        else
            return 1 + countNodes2(root.left) + countNodes2(root.right);
        
    }
    
    int nodeDepth(TreeNode root, int flag){ // flag = 1:left; flag = 2:right
        if(root == null)  return 0;
        return 1 + (flag == 1 ? nodeDepth(root.left,flag) : nodeDepth(root.right,flag));
    }
}
