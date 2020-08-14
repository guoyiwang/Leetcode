import java.util.ArrayList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        levelHelper(ans, root, 0);
        return ans;
    }
    public void levelHelper(List<List<Integer>> res, TreeNode cur, int level){
        if(cur == null) return;

        if(res.size()==level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(cur.val);//
        levelHelper(res, cur.left, level+1);
        levelHelper(res, cur.right, level+1);
    }
}
