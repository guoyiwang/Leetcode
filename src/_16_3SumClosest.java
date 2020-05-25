import java.util.Arrays;
import java.util.Map;

public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int ans = 0;
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int j = i + 1;//
            int k = nums.length - 1;
            while(j<k){
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum == target) return target;
                int currDiff = target - currSum;
                if(Math.abs(currDiff) < Math.abs(diff)){
                    diff = currDiff;
                    ans = currSum;
                }
                if(currSum < target) j++;
                else k--;
            }
        }
        return ans;
    }

}
