package hashTable;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> rst = new ArrayList<Integer>();
    	if(root == null){
    		return rst;
    	}

        help(root, rst);

    	return rst;
    }
	
    void help(TreeNode root, List<Integer> rst){
    	if(root.left != null){
    		help(root.left, rst);
    	}
    	rst.add(root.val);
    	if(root.right != null){
    		help(root.right, rst);
    	}
    }
	
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

