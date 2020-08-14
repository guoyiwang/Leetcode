import java.util.Stack;

public class _98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root){
        return  helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if(node == null) return true;
        int val = node.val;
        if(lower!=null && val <= lower) return false;
        if(upper!=null && val >= upper) return false;

        if(!helper(node.left, lower, val)) return false;
        if(!helper(node.right, val, upper)) return false;
        return true;
    }

    public boolean isValidBST_Iterative(TreeNode root){
        // inorder iterative, left < node < right
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

}
