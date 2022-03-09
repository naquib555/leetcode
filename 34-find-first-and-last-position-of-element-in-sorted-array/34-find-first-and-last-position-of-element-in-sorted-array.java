class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        
        if (start == -1) return new int[] {-1, -1};
        
        return new int[] {start, binarySearch(nums, target, false)};
    }
    
    int binarySearch(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == left || nums[mid - 1] != target) return mid;
                    
                    right = mid - 1;
                } else {
                    if (mid == right || nums[mid + 1] != target) return mid;
                    
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange_old(int[] nums, int target) {
        
        int start = -1;
        int end = -1;
        
        int left = 0;
        int right = nums.length-1;
        
        while (left <= right) {
            int mid = left + (right-left)/2;
            
            if (nums[mid] == target) {
                
                if (mid == 0 || nums[mid - 1] < target) {
                    start = mid;
                } else if(mid == (nums.length-1) || nums[mid + 1] > target) {
                    end = mid;
                }
                if (start == -1 && end == -1) {
                    right = mid - 1;
                } else if(start == -1 && end != -1) {
                    left = mid + 1;
                } else if(end == -1 && start != -1) {
                    right = mid - 1;
                } else {
                    left = right + 1;
                }
                
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {start, end};
    }
}

/*
 0,1,2,3,4,5
[5,7,7,8,8,10]
start = -1
end = 4

l = 0
r = 3
m = 4


*/
