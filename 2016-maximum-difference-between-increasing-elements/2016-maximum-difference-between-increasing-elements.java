class Solution {
    public int maximumDifference(int[] nums) {
        int result = -1;
        
        int left = 0, right = 1;
        
        while (right < nums.length) {
            if (nums[left] > nums[right]) {
                left = right;
                right++;
            } else {
                result = Math.max(result, nums[right] - nums[left]);
                right++;
            }
        }
        
        return result > 0 ? result : -1;
    }
}