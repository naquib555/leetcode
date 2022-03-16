class Solution {
    int[][] gridSum;
    boolean[][] visited;
    int m, n;
    
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (i != m - 1 && j == n - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (i != m - 1 && j != n - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
    
    public int minPathSum_mySolution(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        gridSum = new int[m][n];
        
        visited = new boolean[m][n];
        
        dfs(grid, m - 1, n - 1, 0);
        
        return gridSum[0][0];
        
    }
    
    void dfs(int[][] grid, int i, int j, int sum) {
        if (i < 0 || j < 0 || i > m || j > n)
            return;
        
        sum += grid[i][j];
        dfs(grid, i, j - 1, sum);
        dfs(grid, i - 1, j, sum);
        
        if (visited[i][j])
            gridSum[i][j] = Math.min(gridSum[i][j], sum);
        else {
            gridSum[i][j] = sum;
            visited[i][j] = true;
        }
    }
}