class Solution {
    public int maxProduct(int[] nums) {
        int current = nums[0];
        int max = nums[0];
        
        int result = max;
        
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(max * nums[i], current * nums[i]));
            current = Math.min(nums[i], Math.min(max * nums[i], current * nums[i]));
            
            max = tempMax;
            
            result = Math.max(max, result);
        }
        
        return result;
        
    }
    
    public int maxProduct_old(int[] nums) {
        
        int left = 0;
        int right = 1;
        
        int maxProduct = nums[left];
        int currentProduct = nums[left];
        
        while (right < nums.length) {
            System.out.println(nums[left]);
            if (nums[right] < nums[left]) {
                left = right;
                right++;
                currentProduct = nums[left];
            } else {
                //if (maxProduct == 0) maxProduct = nums[left];
                currentProduct = Math.max(currentProduct, currentProduct * nums[right]);
                maxProduct = Math.max(maxProduct, currentProduct);
                left++;
                right++;
            }
        }
        
        return maxProduct;
        
    }
    
    /*
    
    [2,1,2,3,-2,4]
    
    
    */
}