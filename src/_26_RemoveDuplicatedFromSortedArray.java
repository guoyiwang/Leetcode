public class _26_RemoveDuplicatedFromSortedArray {
    //in the code which in leetcode, the answer is array which could be created by for loop to index in nums
    public int removeDuplicates(int[] nums){
        if(nums.length ==0) return 0;
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){//the first element won't be changed
                index++;
                nums[index] = nums[i];//nums is required be changed which will shown in test
            }
        }
        return index+1;
    }
}
