public class Array {

    public int removeDuplicates(int[] nums){
        int index = 0;
        for(int i=1; i < nums.length; i++){
            if(nums[i]!=nums[i-1]){
                index += 1;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
    public int searchInsertPosition(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;//if the target already in the array
            else if(nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;//if the target isn't in the array, low will be the position could insert the target
    }

    public int maxSubarray(int[] nums){
        if(nums.length == 0) return 0;
        int best = Integer.MIN_VALUE;
        for(int a = 0; a < nums.length; a++){
            if(best<nums[a]) best = nums[a];
        }
        for(int j = 2; j <=nums.length; j++){

            int sum = 0;
            for(int z = 0; z <j; z++){
                sum += nums[z];
                if(best < sum) best = sum;
            }
            for(int i=j; i<nums.length; i++){
                sum += nums[i];
                sum -= nums[i-j];
                if(best < sum) best = sum;
            }
        }
        return best;
    }

    public int maxSubarrayOpt(int[] nums){
        int n = nums.length;
        int[] dp = new int[n]; // dp: dynamic programming
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i-1] > 0? dp[i-1]:0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
