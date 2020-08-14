public class _104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int leftMax = 0;
        int rightMax = 0;
        if(root.left == null){
            leftMax = 0;
        }else {
            leftMax = maxDepth(root.left);
        }
        if(root.right == null){
            rightMax = 0;
        }else {
            rightMax = maxDepth(root.right);
        }
        return 1 + Math.max(leftMax, rightMax);
    }
}
