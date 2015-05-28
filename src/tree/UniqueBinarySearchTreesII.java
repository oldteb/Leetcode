package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rst = new ArrayList<TreeNode>();
        if(n < 1)  return rst;
        rst.add(new TreeNode(1));
        int count = 
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < rst.size(); j++){
                TreeNode temp = new TreeNode(i);
                temp.left = TreeCopy(rst.get(j));
                rst.add(temp);
                if(rst.get(j).right == null){
                    rst.get(j).right = new TreeNode(i);
                }
                else{
                    temp = TreeCopy(rst.get(j));
                    TreeNode scan;
                    for(scan = rst.get(j); scan.right != null; scan = scan.right);
                    scan.right = new TreeNode(i);
                    TreeNode temp2 = temp.right;
                    temp.right = new TreeNode(i);
                    temp.right.left = temp2;
                    rst.add(temp);
                }
            }
        }
        
        return rst;
    }
    
    TreeNode TreeCopy(TreeNode tn){
        TreeNode root = new TreeNode(tn.val);
        if(tn.left != null){
            root.left = TreeCopy(tn.left);
        }
        if(tn.right != null){
            root.right = TreeCopy(tn.right);
        }
        return root;
    }
    
    static void printTree(TreeNode tn){
    	if(tn == null)  return;
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	list.add(tn);
    	while(list.size() != 0){
    		int c = list.size();
    		for(int i = 0; i < c; i++){
    			System.out.print(list.get(0).val + " ");
    			if(list.get(0).left != null)  list.add(list.get(0).left);
    			if(list.get(0).right != null)  list.add(list.get(0).right);
    			list.remove(0);
    		}
    		System.out.print(";");
    	}
    }
    
    public static void main(String[] argv){
    	UniqueBinarySearchTreesII ubst2 = new UniqueBinarySearchTreesII();
    	List<TreeNode> ans = ubst2.generateTrees(3);
    	StringBuffer sb = new StringBuffer(3);
    	String s;
    	Integer
    	for(TreeNode tn : ans){
    		printTree(tn);
    	}
    }
}
