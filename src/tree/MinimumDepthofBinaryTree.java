package tree;

/**
 * 
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * @author yunhe
 *
 */
public class MinimumDepthofBinaryTree {
	
	//  simple code
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        return dfs(root,1, Integer.MAX_VALUE);
    }
    
    int dfs(TreeNode root, int lvl, int minDep){
        if(lvl >= minDep){
            return minDep;
        }
        if(root.left == null && root.right == null){
            return Math.min(lvl, minDep);
        }
        if(root.left != null)
            minDep = dfs(root.left, lvl+1, minDep);
        if(root.right != null)
            minDep = dfs(root.right, lvl+1, minDep);
        return minDep;
    }
	
	
    // compliated code
    public int minDepth2(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        int min = Integer.MAX_VALUE;
        return help(root, min, 1);
    	
    }
    
    int help(TreeNode root, int min, int curr){
    	if(curr > min){
    		return min;
    	}
    	if(root.left == null && root.right == null){
    		if(min > curr)  return curr;
    		else  return min;
    	}
    	if(root.left != null){
    		min = help(root.left,min,curr+1);
    	}
    	if(root.right != null){
    		min = help(root.right,min,curr+1);
    	}
    	
    	return min;
    }
}

