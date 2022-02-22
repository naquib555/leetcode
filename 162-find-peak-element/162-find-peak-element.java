class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 1) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
    
    /*
    
    [1,2,1,3,5,6,7]
    [1,2,3,4,5,6,4]
    [1,2,3,,5,6,4]
    
    */
}