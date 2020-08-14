public class _701_InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root==null) return new TreeNode(val);
        TreeNode cur = root;
        while(true){
            if(cur.val <=val){
                if(cur.right!=null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            }else {
                if(cur.left !=null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
    public TreeNode insertIntoBST_new(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val > val){//go left
            if(root.left == null){
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left, val);
        }
        if(root.val < val){//go right
            if(root.right == null){
                root.right = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.right, val);
        }
        return root;
    }
}
