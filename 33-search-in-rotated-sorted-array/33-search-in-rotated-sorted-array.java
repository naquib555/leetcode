class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return mid;
            
            // left portion
            if (nums[left] <= nums[mid]) {
                if(target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            // right  portion
            else if (target < nums[mid] || target > nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        
        /*
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                if(nums[left] > target) left = mid+1;
                else right = mid-1;
            } else {
                if(nums[left] <= target && nums[right] > target) {
                    right = mid-1;
                } else left = mid+1;
            }
        }
        */
        return -1;
    }
    
    /*
    
    [4,5,6,7,0,1,2]     0
    
    
    
    
    */
    
}