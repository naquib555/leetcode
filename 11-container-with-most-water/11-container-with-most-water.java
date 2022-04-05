class Solution {
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int length = Math.min(height[left], height[right]);
            int width = right - left;
            
            area = Math.max(area, length * width);
            
            if (height[left] < height[right]) left++;
            else right--;
        }
        return area;
    }
    
    public int maxArea_bruteforce(int[] height) {
        int area = Integer.MIN_VALUE;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int length = Math.min(height[i], height[j]);
                int width = j - i;
                
                area = Math.max(area, length * width);
            }
        }
        
        return area;
    }
}

/*
1, 8, 6, 2, 5, 4, 8, 3, 7
0  1  
0 1 6 2 2 4 4 3 3
0 8 8 6 5 5 8 8 7

*/