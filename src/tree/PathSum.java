package tree;

/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * 
 * @author yunhe
 *
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        
        return help(root, 1, root.val, sum);
    }
    
    Boolean help(TreeNode root, int level, int sum, int target){
        if(root.left == null && root.right == null){
            if(sum == target){
                return true;
            }
            return false;
        }
        if(root.left != null){
            if(help(root.left, level+1, sum+root.left.val, target))  return true;
        }
        if(root.right != null){
            if(help(root.right, level+1, sum+root.right.val, target))  return true;
        }
        return false;
    }
    
    public static void main(String[] argv){
    	PathSum ps = new PathSum();
    	TreeNode t1 = new TreeNode(5);
    	TreeNode t2 = new TreeNode(4);
    	TreeNode t3 = new TreeNode(11);
    	t1.left = t2;
    	t2.right = t3;

    	System.out.println(ps.hasPathSum(t1, 20));
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
    TreeNode(int x) { val = x; }
}
