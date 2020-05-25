public class _162_FindPeakElement {
    public int findPeakElement(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                return i;
            }
        }
        return nums.length - 1;
    }
    public int findPeakElementBinarySearch(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;//what's the different with right = mid or right = mid - 1; if right = mid - 1, it will cause left > right early
            }else {
                left = mid + 1;
            }
        }return left;
    }
}
