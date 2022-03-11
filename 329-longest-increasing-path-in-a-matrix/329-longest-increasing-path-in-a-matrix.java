class Solution {
    int [][] lip;
    int [][] matrix;
    
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        lip = new int[m][n];
        
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                len = Math.max(len, dfs(i, j, m, n, -1));
            }
        }
        return len;
    }
    
    int dfs(int i, int j, int m, int n, int currValue) {
        if (i < 0 || j < 0 || i == m || j == n || currValue >= matrix[i][j])
            return 0;
        
        if (lip[i][j] != 0) return lip[i][j];
        
        int currLen = 1;
        
        currLen = Math.max(currLen, 1 + dfs(i + 1, j, m, n, matrix[i][j]));
        currLen = Math.max(currLen, 1 + dfs(i - 1, j, m, n, matrix[i][j]));
        currLen = Math.max(currLen, 1 + dfs(i, j + 1, m, n, matrix[i][j]));
        currLen = Math.max(currLen, 1 + dfs(i, j - 1, m, n, matrix[i][j]));
        
        lip[i][j] = currLen;
        
        return currLen;
    }
}