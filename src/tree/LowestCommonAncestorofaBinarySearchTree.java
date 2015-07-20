package tree;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Given a binary search tree (BST), find the lowest 
 * common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * ¡°The lowest common ancestor is defined between two 
 * nodes v and w as the lowest node in T that has both 
 * v and w as descendants (where we allow a node to be 
 * a descendant of itself).¡±
 * 
 *<p>
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * </p>      
 * For example, the lowest common ancestor (LCA) of nodes 
 * 2 and 8 is 6. Another example is LCA of nodes 2 and 4 
 * is 2, since a node can be a descendant of itself acc-
 * ording to the LCA definition.
 * 
 * 
 * @author yunhe
 *
 */
public class LowestCommonAncestorofaBinarySearchTree {
    List<TreeNode> pList = new ArrayList<TreeNode>();
    List<TreeNode> qList = new ArrayList<TreeNode>();
    List<TreeNode> trace = new ArrayList<TreeNode>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(dfs(root,p,q) == 0)  return null;
        for(int i = 0; i < Math.min(pList.size(), qList.size()); i++){
            if(pList.get(i) == qList.get(i))  continue;
            return pList.get(i-1);
        }
        
        return pList.get(Math.min(pList.size(), qList.size())-1);
    }
    
    int dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)  return 0;
        trace.add(root);
        if(root == p)  pList.addAll(trace);
        if(root == q)  qList.addAll(trace);
        if(pList.size() != 0 && qList.size() != 0)  return 1;
        if(dfs(root.left,p,q) == 1)  return 1;
        if(dfs(root.right,p,q) == 1)  return 1;
        trace.remove(trace.size()-1);
        return 0;
    }
}
