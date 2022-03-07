class Solution {

    int[] prefixSum;
    int totalSum;
    
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        this.totalSum = 0;
        
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        double target = Math.random() * this.totalSum;
        
        int left = 0;
        int right = this.prefixSum.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (target > this.prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */