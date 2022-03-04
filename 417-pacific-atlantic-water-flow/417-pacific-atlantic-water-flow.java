class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        if (rows == 0 || cols == 0) return new ArrayList<>();
        
        boolean [][] pac = new boolean[rows][cols];
        boolean [][] alt = new boolean[rows][cols];
        
        for (int col = 0; col < cols; col++) {
            dfs(0, col, rows, cols, heights, pac, heights[0][col]);
            dfs(rows - 1, col, rows, cols, heights, alt, heights[rows - 1][col]);
        }
        
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, rows, cols, heights, pac, heights[row][0]);
            dfs(row, cols - 1, rows, cols, heights, alt, heights[row][cols - 1]);
        }
        
        List<List<Integer>> results = new LinkedList<>();
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pac[row][col] && alt[row][col]) {
                    results.add(List.of(row, col));
                }
            }
        }
        return results;
    }
    
    void dfs(int r, int c, int rows, int cols, int[][] heights, boolean[][] visited, int prevHeight) {
        
        if (r < 0 || c < 0 || r == rows || c == cols || visited[r][c] || heights[r][c] < prevHeight)
            return;
        
        visited[r][c] = true;
        
        dfs(r + 1, c, rows, cols, heights, visited, heights[r][c]);
        dfs(r - 1, c, rows, cols, heights, visited, heights[r][c]);
        dfs(r, c + 1, rows, cols, heights, visited, heights[r][c]);
        dfs(r, c - 1, rows, cols, heights, visited, heights[r][c]);
        
    }
}

/*
    0   1   2
 0  10  10  10
 1  10  1   10
 2  10  10  10

*/