class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int right = 2;
        
        while(right < nums.length) {
            if(nums[left] == nums[right]) {
                if(nums[left-1] == nums[right]) {
                    right++;
                } else {
                    if(left+1 != right) {
                        int temp = nums[left+1];
                        nums[left+1] = nums[right];
                        nums[right] = temp;
                    }
                    left++;
                    right++;
                }
            } else {
                if(left+1 != right) {
                    int temp = nums[left+1];
                    nums[left+1] = nums[right];
                    nums[right] = temp;
                }
                left++;
                right++;
            }
        }
        return left+1;
    }
}