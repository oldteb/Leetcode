package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null)  return rst;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> exp_list = new LinkedList<TreeNode>();
        queue.add(root);
        exp_list.add(root);
        
        while(exp_list.isEmpty() == false){
        	TreeNode tn = exp_list.getFirst();
        	if(tn.left != null){
        		exp_list.add(tn.left);
        		queue.add(queue.indexOf(tn), tn.left);
        	}
        	if(tn.right != null){
        		exp_list.add(tn.right);
        		queue.add(queue.indexOf(tn), tn.right);
        	}
        	exp_list.remove(0);
        }
        
        for(TreeNode tnode : queue){
        	rst.add(tnode.val);
        }
        
        return rst;
    }
    
    
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null)  return rst;
        StackNode sn = new StackNode(root,0);
        Stack<StackNode> stack = new Stack<StackNode>();
        while(true){
            if(sn.dir == 0){
                sn.dir = 1;
                if(sn.tn.left != null){
                    stack.push(sn);
                    sn = new StackNode(sn.tn.left,0);
                } 
            }
            else if(sn.dir == 1){
                sn.dir = 2;
                if(sn.tn.right != null){
                    stack.push(sn);
                    sn = new StackNode(sn.tn.right,0);
                }
            }
            else{
                rst.add(sn.tn.val);
                if(stack.size() == 0)  break;
                else sn = stack.pop();
            }
        }
        return rst;
    }
    
    class StackNode{
        int dir;
        TreeNode tn;
        
        StackNode(TreeNode tn, int dir){
            this.dir = dir;
            this.tn = tn;
        }
    }
}
