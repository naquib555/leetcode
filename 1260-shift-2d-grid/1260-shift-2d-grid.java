class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        while (k-- != 0) {
            int prev = grid[m - 1][n - 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = grid[i][j];
                    grid[i][j] = prev;
                    prev = temp;
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            result.add(row);
        }
        
        return result;
    }
}