package tree;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root = null){
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

