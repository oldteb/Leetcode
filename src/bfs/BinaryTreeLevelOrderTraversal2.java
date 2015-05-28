package bfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if(root == null){
    		return new ArrayList<List<Integer>>();
    	}
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	List<TreeNode> temp = new ArrayList<TreeNode>();
    	List<Integer> buf = new ArrayList<Integer>();
    	temp.add(root);
    	help(temp, 1, buf, rst);
	    return rst;   
    }
    
    void help(List<TreeNode> temp, int num, List<Integer> buf, List<List<Integer>> rst){
    	if(num == 0)  return;
    	buf.add(temp.get(0).val);
    	if(temp.get(0).left != null){
    		temp.add(temp.get(0).left);
    	}
    	if(temp.get(0).right != null){
    		temp.add(temp.get(0).right);
    	}
    	temp.remove(0);
    	
    	if(num == 1){
    		num = temp.size();
    		rst.add(0, buf);
    		help(temp, num, new ArrayList<Integer>(), rst);
    	}
    	else{
    		num--;
    		help(temp, num, buf, rst);
    	}
    }
}








class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

