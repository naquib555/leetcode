class Solution {
    public int mySqrt(int x) {
        
        if(x < 2) return x;
        
        int low = 2;
        int high = x / 2;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            long sqrt = (long) mid * mid;
            
            if(sqrt < x) {
                low = mid + 1;
            } else if (sqrt > x) {
                high = mid - 1;
            } else return mid;
        }
        
        return high;
        
    }
    
    
}