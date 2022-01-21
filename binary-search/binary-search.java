class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, target, nums);
    }
    
    int binarySearch(int low, int high, int target, int[] nums) {
        if(high >= low) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) return binarySearch(low, mid-1, target, nums);
            return binarySearch(mid+1, high, target, nums);
        }
        return -1;
    }
}