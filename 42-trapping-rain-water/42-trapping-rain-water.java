class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        int left = 0;
        int right = n - 1;
        
        int maxLeft = height[0];
        int maxRight = height[n - 1];
        
        int totalTrapWater = 0;
        
        while (left < right) {
            
            if (maxLeft <= maxRight) {
                left++;
                
                maxLeft = Math.max(maxLeft, height[left]);
                totalTrapWater += maxLeft - height[left];
                
            } else {
                right--;
                
                maxRight = Math.max(maxRight, height[right]);
                totalTrapWater += maxRight - height[right];
                
            }
        }
        return totalTrapWater;
        
    }
    
    public int trap_old(int[] height) {
        int n = height.length;
        
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int[] minLR = new int[n];
        
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        
        for (int i = 0; i < n; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        
        int totalTrapWater = 0;
        
        for (int i = 0; i < n; i++) {
            int trap = minLR[i] - height[i];
            if (trap >= 0) totalTrapWater += trap;
        }
        return totalTrapWater;
    }
}