class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int lis = 1;
        
        for(int i=dp.length-2; i>=0; i--) {
            
            for(int j=i+1; j<dp.length; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }
        
        return lis;
    }
}