class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        int first = cost[0];
        int second = cost[1];
        
        int curr = 0;
        
        for (int i = 2; i < cost.length; i++) {
            curr = Math.min(cost[i] + first, cost[i] + second);
            first = second;
            second = curr;
        }
        
        return Math.min(first, second);
    }
    
    public int minCostClimbingStairs_dparray(int[] cost) {
        int[] dp = new int[cost.length];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min (cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
        }
        
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}