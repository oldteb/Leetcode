package Array;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
    		return null;
    	}
        
    	TreeNode root = bTreeBuilder(preorder, inorder, 0, preorder.length, 0, inorder.length);
    	
    	return root;
    }
    
    TreeNode bTreeBuilder(int[] preorder, int[] inorder, int pre_s, int pre_len, int in_s, int in_len){
    	int mid_idx = 0;
    	while(mid_idx < inorder.length){
    		if(inorder[in_s + mid_idx] == preorder[pre_s]){
    			break;
    		}
    		mid_idx++;
    	}
    	TreeNode root = new TreeNode(preorder[pre_s]);
    	
    	Math.m
    	
    	if(mid_idx > 0){
    		root.left = bTreeBuilder(preorder, inorder, pre_s+1, mid_idx, in_s, mid_idx);
    	}
    	
    	if(in_len - mid_idx -1 > 0){
    		root.right = bTreeBuilder(preorder, inorder, pre_s + mid_idx +1 , in_len - mid_idx -1, in_s + mid_idx + 1, in_len - mid_idx -1);
    	}

		return root;
    }
    
    void printTree(TreeNode root){
    	if(root.left != null){
    		printTree(root.left);
    	}
    	if(root.right != null){
    		printTree(root.right);
    	}
    	System.out.print(root.val + " ");
    }
    
    public static void main(String argv[]){
    	ConstructBinaryTreefromPreorderandInorderTraversal cbtipt = new ConstructBinaryTreefromPreorderandInorderTraversal();
    	int[] preorder = {1,2,4,3,5,6};
    	int[] inorder = {4,2,1,5,3,6};
    	TreeNode root = cbtipt.buildTree(preorder, inorder);
    	cbtipt.printTree(root);
    	
    }
}


