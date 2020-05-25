public class _238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] output = new int[nums.length];
        for(int i = 0; i < output.length; i++){
            output[i] = 1;
        }
        //times all the elements in the left side of chosed element
        output[1] = nums[0];
        for(int i = 1; i < nums.length-1; i++){
            output[i+1] = output[i]*nums[i];
        }

        //time all the elements in the right side of chosed element
        int temp = 1;
        for(int i = nums.length - 1; i >0; i--){
            temp = temp * nums[i];
            output[i-1] = output[i-1] * temp;
        }
        return output;
    }
}
