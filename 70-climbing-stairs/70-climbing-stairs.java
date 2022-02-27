class Solution {
    
    public int climbStairs(int n) {
        
        double sqrt5 = Math.sqrt(5);
        
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        
        return (int) (fibn / sqrt5);
        
        
    }
    
    public int climbStairs_n(int n) {
        
        if (n == 1) return 1;
        
        int first = 1;
        int second = 2;
        
        for (int i = 3; i <= n; i++) {
            int third = second;
            second = third + first;
            first = third;
        }
        
        return second;
        
        
    }
    
    /*
    1 1 1 1 1 1
    n=6
    6-2=4-
    4-2=2
    2-2=0
    
    1+1=2
    
    */
}