class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        
        int totalSum = 0;
        
        int left = 0;
        int right = n - k;
        
        for (int i = right; i < cardPoints.length; i++) 
            totalSum += cardPoints[i];
        
        int result = totalSum;
        
        while (right < n) {
            totalSum += cardPoints[left] - cardPoints[right];
            result = Math.max(result, totalSum);
            left++;
            right++;
        }
        
        return result;
    }
}