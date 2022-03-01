class Solution {
    public int uniquePaths(int m, int n) {
        //return travel(0, 0, m, n, 0);
        
        int [][] dp = new int[m][n];
        
        for (int[] arr : dp)
            Arrays.fill(arr, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    int travel(int mStep, int nStep, int m, int n, int count) {
        
        if (mStep == m - 1 && nStep == n - 1) return ++count;
        
        if (mStep < m)
            count = travel(mStep + 1, nStep, m, n, count);
        if (nStep < n)
            count = travel(mStep, nStep + 1, m, n, count);
        
        return count;
    }
    
    /*
    m = 3
    n = 2
    
    mStep++(down)
    nStep++(right)
    
    if (mStep < m)
    
    if (nStep <= n)
    
    if (mStep == m - 1 && nStep == n - 1) count++
    
    */
}