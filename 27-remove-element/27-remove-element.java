class Solution {
    public int removeElement(int[] nums, int val) {
        int swapIndex = nums.length-1;
        int i = 0;
        for(; i <= swapIndex;) {
            if(nums[swapIndex] == val) swapIndex--;
            else if(nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[swapIndex];
                nums[swapIndex--] = temp;
                i++;
            } else i++; 
        }
        return i;
    }
}