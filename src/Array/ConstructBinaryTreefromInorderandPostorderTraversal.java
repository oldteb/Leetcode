package Array;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1){
    		return null;
    	}

    	TreeNode root = bTreeBulider(inorder, postorder, 0, inorder.length, 0, postorder.length);

    	return root;
    }
    
    TreeNode bTreeBulider(int[] inorder, int[] postorder, int ins, int in_len, int posts, int post_len){
    	int mid_index = 0;
    	for(int i = 0; i < in_len; i++){
    		if(inorder[i+ins] == postorder[posts + post_len-1]){
    			mid_index = i+ins;
    			break;
    		}
    	}
    	TreeNode root = new TreeNode(inorder[mid_index]);
    	
    	if(mid_index - ins > 0){
    		root.left = bTreeBulider(inorder, postorder, ins, mid_index-ins, posts, mid_index-ins);
    	}
    	
    	if(mid_index < ins + in_len - 1){
    		root.right = bTreeBulider(inorder, postorder, mid_index+1, ins+in_len-1-mid_index, posts+mid_index-ins, ins+in_len-1-mid_index);
    	}
    	
    	return root;
    }
    
    void printTree(TreeNode root){
    	System.out.print(root.val + " ");
    	if(root.left != null){
    		printTree(root.left);
    	}
    	if(root.right != null){
    		printTree(root.right);
    	}
    }
    
    public static void main(String argv[]){
    	ConstructBinaryTreefromInorderandPostorderTraversal cbtipt = new ConstructBinaryTreefromInorderandPostorderTraversal();
    	int[] inorder = {4,2,1,5,3,6};
    	int[] postorder = {4,2,5,6,3,1};
    	TreeNode root = cbtipt.buildTree(inorder, postorder);
    	cbtipt.printTree(root);
    	
    }
	
	
}








//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
