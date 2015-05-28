package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
//import tree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null){
        	return rst;
        }
        int flag = 0;   // left to right
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int count = 1;
        while(queue.isEmpty() == false){
        	List<Integer> temp = new ArrayList<Integer>());
        	int c = count;
        	count = 0;
        	for(int i = 0; i < c; i++){
        		if(flag == 0){
        			temp.add(queue.get(0).val);
        		}
        		else{
        			temp.add(0,queue.get(0).val);
        		}
        		if(queue.get(0).left != null){
        			queue.add(queue.get(0).left);
        			count++;
        		}
        		if(queue.get(0).right != null){
        			queue.add(queue.get(0).right);
        			count++;
        		}
        		queue.remove(0);
        	}
        	rst.add(temp);
        	flag = 1 - flag;
        }
        		
        return rst;
    }
}
