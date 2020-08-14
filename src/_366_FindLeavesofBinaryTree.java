import java.util.ArrayList;
import java.util.List;

public class _366_FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); //List<List<Integer>> ans = new ArrayList<>();
        helperHeight(root ,ans);
        return ans;
    }

    public int helperHeight(TreeNode root, List<List<Integer>> res){
        if(root == null) return -1;
        int height = 1 + Math.max(helperHeight(root.left, res), helperHeight(root.right, res));
        if(res.size() == height ) res.add(new ArrayList<Integer>());// not sure res.size() < height + 1
        res.get(height).add(root.val);
        return height;
    }
}
