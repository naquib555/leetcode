class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        /*
        [1,2,3,4]
        [1,1,2,6]
        [1,1,2,6]
        */
        output[0] = 1;
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix *= nums[i];
        }
        
        return output;
    }
    
    
    public int[] productExceptSelf_extraMemory(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) nums[i] = postfix[i + 1];
            else if (i + 1 >= nums.length) nums[i] = prefix[i - 1];
            else nums[i] = prefix[i - 1] * postfix[i + 1];
        }
        return nums;
    }
}

/*
[1,2,3,4]
[1,1,2,6]
[1,1,2,6]

[1,2,3,4]
[1,2,6,24]
[24,24,12,4]
[-1,1,0,-3,3]
[-1,-1,0,0,0]
*/