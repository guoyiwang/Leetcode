public class _105_ConstructBinaryTreeFromPreorderandInorderTraversal {
    //find root from preorder, the left side of root in inorder is left tree, the right side of root in inorder is right tree.
    //the preStrat in root.right, inIndex - inStart + 1 include the root and all left tree, preStart + inIndex - inStart + 1 is the begin root of right tree.
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);//first element in preorder is the root
        int inIndex = 0;//index of current root in inorder
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val){
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + 1 + inIndex - inStart , inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
