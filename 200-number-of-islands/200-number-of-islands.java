class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean [][] visited = new boolean[rows][cols];
        
        int noOfIsland = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    noOfIsland++;
                    dfs(r, c, rows, cols, visited, grid);
                }
            }
        }
        return noOfIsland;
        
    }
    
    void dfs(int r, int c, int rows, int cols, boolean[][] visited, char[][] grid) {
        if (r < 0 || c < 0 || r == rows || c == cols || visited[r][c] || grid[r][c] == '0')
            return;
        
        visited[r][c] = true;
        
        dfs(r + 1, c, rows, cols, visited, grid);
        dfs(r - 1, c, rows, cols, visited, grid);
        dfs(r, c + 1, rows, cols, visited, grid);
        dfs(r, c - 1, rows, cols, visited, grid);
    }
}

/*
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]

*/