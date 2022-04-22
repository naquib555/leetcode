class Solution {
    public int jump(int[] nums) {
        
        int result = 0;
        
        int left = 0;
        int right = 0;
        
        while (right < nums.length - 1) {
            int furthest = 0;
            
            for (int i = left; i <= right; i++) {
                furthest = Math.max(furthest, i + nums[i]);
            }
            
            left = right + 1;
            right = furthest;
            
            result++;
        }
        
        return result;
    }
}