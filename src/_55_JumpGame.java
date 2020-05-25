public class _55_JumpGame {
    public boolean canJumpFromPosition(int position, int[] nums){
        if(position == nums.length-1){//set the condition when return ture
            return true;
        }
        int furestJump = Math.min(position + nums[position], nums.length-1);
        for(int nextPosition = position + 1; nextPosition <= furestJump; nextPosition++){//nextPosition = position + 1, when nums[nextPosition] = 0, nextPosition > furestJump
            if(canJumpFromPosition(nextPosition, nums)){
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums){
        return canJumpFromPosition(0, nums);
    }
}
