public class _156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root){
        if(root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        newRoot.left = root.right;
        newRoot.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree_Iterative(TreeNode root){
        TreeNode curr = root;
        TreeNode pre = null;
        TreeNode temp = null;
        TreeNode next = null;
        while(curr !=null ){
            next = curr.left;
            curr.left = temp;
            temp = curr.right;

            curr.right = pre;
            curr = pre;
            curr = next;
        }
        return pre;
    }
}
