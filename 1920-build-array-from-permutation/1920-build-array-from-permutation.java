class Solution {
    public int[] buildArray(int[] nums) {
        /*
        nums = [0,2,1,5,3,4]
        q = 6
        r = 2
        p = 1 % 6 = 1
        
        b = 6 + 2 = 8
        b = p*q + r
        */
        
        int q = nums.length;
        
        for (int i = 0; i < q; i++) {
            nums[i] = (nums[nums[i]] % q) * q + nums[i];
        }
        
        for (int i = 0; i < q; i++)
            nums[i] = nums[i] / q;
        
        return nums;
        
    }
}