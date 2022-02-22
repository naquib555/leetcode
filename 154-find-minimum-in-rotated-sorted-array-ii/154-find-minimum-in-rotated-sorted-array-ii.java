class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];
        
        return nums[findRotatedIndex(nums)];
        
    }
    
    int findRotatedIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid + 1;
            else right--;
        }
        return left;
    }
    
    /*
    [2,2,2,0,1]
    
    [2,3,4,4,4,4,5,0,1]
    [4,0,1,1,1,2,3]
    
    
    [4,5,6,7,0,1,4]
    
    [1,2,2,2,2,2,0]
    
    [1,1,1,1]
    [1,0,1,1,1,1,1,1,1,1,1,1]
    
    
    */
}