import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _330_PatchingArray {
    public int minPatches(int[] nums, int n){
        //Interate each number in range[1,n] inclusie
        int originLength = nums.length;
        if(nums.length == 0) {
            nums = addElement(nums, 1);
        }
        addValue:
        for(int i = 1; i <= n; i++) {
            int target = i;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (target - nums[j] == 0) {
                    continue addValue;
                }
            }
            if (!findComplement(nums, i, nums.length - 1)) {
                nums = addElement(nums, i);
            } else {
                continue;
            }
        }
        return nums.length - originLength;
    }

    public boolean findComplement(int[] nums, int target, int index){
        //if target is less than the biggest in nums, directly find in nums
        int complement = target - nums[index];
        if(complement ==0) return true;
        for(int i = 0; i<index; i++){
            if(complement == nums[i] && i!=index) return true;
        }
        return false;

    }
    public int[] addElement(int[] nums, int e){
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = e;
        Arrays.sort(nums);
        return nums;
    }
}
