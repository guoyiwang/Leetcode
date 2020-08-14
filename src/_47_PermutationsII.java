import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for(int i = 0; i < nums.length; i++){
                //when nums[i]==nums[i-1] and used[i-1] is false, which means the permutations about used[1] are added in list
                if(used[i] || i >0 && nums[i]==nums[i-1] && !used[i-1])continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(list, tempList, nums, used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
}
