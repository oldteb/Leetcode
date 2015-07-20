package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Given a binary tree, imagine yourself standing on the 
 * right side of it, return the values of the nodes you can
 * see ordered from top to bottom.
 * 
 * <p>For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * <p>You should return [1, 3, 4].
 * 
 * 
 * 
 * @author yunhe
 *
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null)  return rst;
        dfs(rst, root, 0);
        return rst;
    }
    
    void dfs(List<Integer> rst, TreeNode root, int lvl){
        if(root == null)  return;
        if(rst.size() <= lvl){
            rst.add(root.val);
        }
        dfs(rst, root.right, lvl+1);
        dfs(rst, root.left, lvl+1);
    }
}
