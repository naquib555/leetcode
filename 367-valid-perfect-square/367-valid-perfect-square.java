class Solution {
    public boolean isPerfectSquare(int num) {
        
        if (num < 2) return true;
        
        long left = 2;
        long right = num / 2;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            long perfectSquare = mid * mid;
            
            if (perfectSquare == num) return true;
            else if (perfectSquare > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}