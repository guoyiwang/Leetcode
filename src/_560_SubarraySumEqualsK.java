public class _560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        //sum[1] means add the first element from nums
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int count = 0;
        for(int start = 0; start < nums.length; start++){
            for(int end = start+1; end <= nums.length; end++){//end <= because sum.length = nums.length + 1 which because sum[0] is 0.
                if (k == (sum[end] - sum[start])) count++;
            }
        }
        return count;
    }
}
