import java.util.Stack;

public class _285_InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode P) {
        Stack<TreeNode> stack = new Stack<>();
        boolean isP = false;
        while(root != null || !stack.isEmpty()){
            while( root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//all the note pop out are in order
            if( isP) return root;
            if( root == P) isP = true;
            root = root.right;
        }
        return null;
    }
}
