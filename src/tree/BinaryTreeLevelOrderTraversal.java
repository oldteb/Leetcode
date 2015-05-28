package tree;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null){
            return rst;
        }
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(queue.size() != 0){
            int d = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < d; i++){
                temp.add(queue.get(0).val);
                if(queue.get(0).left != null){
                    queue.add(queue.get(0).left);
                }
                if(queue.get(0).right != null){
                    queue.add(queue.get(0).right);
                }
                queue.remove(0);
            }
            rst.add(temp);
        }
        
        return rst;
    }
}
