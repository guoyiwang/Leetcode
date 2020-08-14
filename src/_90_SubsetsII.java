import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;//Avoid duplication, like [1, 2] and [1, 2] when input is [1,2,2]
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size()-1);
        }
    }
}
