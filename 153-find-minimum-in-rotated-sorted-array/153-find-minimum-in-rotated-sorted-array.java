class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        
        int rotatedIndex = findRotatedIndex(nums);
        
        System.out.println(rotatedIndex);
        
        return nums[rotatedIndex];
    }
    
    int findRotatedIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            
            if (nums[mid] > nums[left]) left = mid;
            else right = mid;   
        }
        return -1;
    }
    /*
    [4,5,1,2,3]
    */
    
}