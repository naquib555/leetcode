class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        
        if (i >= 0) {
            int j = nums.length - 1;
            
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            
        }
        reverse(nums, i + 1);
        
        
        
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

/*
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

*/