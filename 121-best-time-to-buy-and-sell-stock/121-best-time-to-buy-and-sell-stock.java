class Solution {
    public int maxProfit(int[] prices) {
        
        int minStock = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        
        int left = 0;
        int right = 1;
        
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                minStock = prices[right];
                left = right;
                right++;
            } else {
                maxProfit = Math.max(maxProfit, prices[right]-prices[left]);
                right++;
            }
        }
        
        return maxProfit > 0 ? maxProfit : 0;
        
    }
    
    /*
    
    [7,1,5,3,6,4]
    [7,5,7,1,6,4]
    
    find min stock
    
    7
    minStock=7/5
    maxProfit=2
    1
    profit=
    
    
    */
}