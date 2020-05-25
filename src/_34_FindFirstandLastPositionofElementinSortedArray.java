public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target){
        if(nums.length ==0) return new int[]{-1, -1};
        int left = searchEqualorGreater(nums, target);
        if(nums[left] !=target) return new int[]{-1,-1};
        int leftBiggerTarget = searchEqualorGreater(nums, target + 1);
        int right = -1;
        if(nums[leftBiggerTarget] >= target + 1){
            right = leftBiggerTarget - 1;
        }else {
            right = leftBiggerTarget;
        }
        return new int[] {left, right};
    }

    public int searchEqualorGreater(int[] nums, int target){
        int left = 0, right = nums.length -1;

        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;//this poistion is always eaqual to target. If target isn't in nums[], the number in position will greater than target or the last element in nums[].
    }
}
