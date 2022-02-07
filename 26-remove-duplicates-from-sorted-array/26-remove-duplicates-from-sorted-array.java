class Solution {
    public int removeDuplicates(int[] nums) {
        int right = 1;
        int left = 1;
        
        while(right < nums.length) {
            if(nums[left-1] == nums[right]) {
                right++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
        return left;
    }
}