class Solution {
    int[][] grid;
    boolean[][] visited;
    int rows, cols, count, maxIsland;
    
    Map<Integer, Integer> gridMap;
    
    int[] rowDir = {0, 1, 0, -1};
    int[] colDir = {1, 0, -1, 0};
    
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        
        rows = grid.length;
        cols = grid[0].length;
        
        visited = new boolean[rows][cols];
        
        count = 0;
        
        gridMap = new HashMap<>();
        
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    count++;
                    gridMap.put(count + 1, dfs(r, c));
                } 
            }
        }
        System.out.println(gridMap);
        
        if (gridMap.size() == 0)
            return 1;
        else if (gridMap.size() == 1) {
            int totalValue = gridMap.values().stream().mapToInt(v -> v).sum();
            
            if (totalValue == rows * cols)
                return totalValue;
        }
            
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nr = r + rowDir[i];
                        int nc = c + colDir[i];

                        if (nr >= 0 && nc >= 0 
                            && nr < rows && nc < cols 
                            && grid[nr][nc] != 0)
                            
                            neighbors.add(grid[nr][nc]);
                    }
                    System.out.println(neighbors);
                    int neighborSum = 0;
                    for (Integer neighbor : neighbors) {
                        neighborSum += gridMap.get(neighbor);
                    }
                    maxIsland = Math.max(maxIsland, neighborSum + 1);
                    }
            }
        }
        
        return maxIsland;
    }
    
    public int dfs(int r, int c) {
        if (r < 0 || c < 0 || r == rows || c == cols || grid[r][c] == 0)
            return 0;
        
        int islandCount = 0;
        
        if (grid[r][c] == 1) {
            grid[r][c] += count;
            islandCount++;
            
            for (int i = 0; i < 4; i++) {
                islandCount += dfs(r + rowDir[i], c + colDir[i]);
            }
        }
        return islandCount;
    }
    
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
    /*
    
[[1,1],[1,0]]
[[1,1],[1,1]]
[[1,0,1],[0,1,1],[0,1,0]]
    */
    
}