class Solution {
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        visited = new boolean[m][n];
        
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(grid, i, j, m, n));
            }
        }
        
        return ans;
    }
    
    int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0)
            return 0;
        
        visited[i][j] = true;
        
        int area = 1;
        area += dfs(grid, i + 1, j, m, n);
        area += dfs(grid, i - 1, j, m, n);
        area += dfs(grid, i, j - 1, m, n);
        area += dfs(grid, i, j + 1, m, n);
        
        return area;
    }
}