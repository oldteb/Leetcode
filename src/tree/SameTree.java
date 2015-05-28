package tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        else if(p == null || q == null)  return false;
        
        return help(p,q);
    }
    
    boolean help(TreeNode p, TreeNode q){
        if(p.val != q.val)  return false;
        if(p.left != null && q.left != null){
            if(help(p.left,q.left) == false)  return false;
        }
        else if(p.left != null || q.left != null)  return false;
        if(p.right != null && q.right != null){
            if(help(p.right,q.right) == false)  return false;
        }
        else if(p.right != null || q.right != null)  return false;
        
        return true;
    }
}
