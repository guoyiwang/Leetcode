import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversalbyRecursive(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        if(root != null) {helper(ans, root);}
        return ans;
    }
    public void helper(List<Integer> ans, TreeNode curr){
        ans.add(curr.val);
        if(curr.left!=null)helper(ans, curr.left);
        if(curr.right!=null)helper(ans, curr.right);
    }

    public List<Integer> preorderTraversalbyIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();//last in first out
        List<Integer> traversal = new ArrayList<>();
        if(root != null){
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode curr = stack.pop();
                traversal.add(curr.val);
                if(curr.right!=null) stack.push(curr.right);
                if(curr.left !=null) stack.push(curr.left);//last in, first out
            }
        }
        return traversal;
    }

}
