class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] lives = new int[m][n];
        
        for (int[] live : lives)
            Arrays.fill(live, -1);
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Deque<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0, 0, k});
        
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            
            int r = pop[0];
            int c = pop[1];
            int dist = pop[2];
            int l = pop[3];
            
            if (r == m - 1 && c == n - 1)
                return dist;
            
            if (grid[r][c] == 1)
                l -= 1;
            
            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                
                Pair<Integer, Integer> visitedPair = new Pair<>(nr, nc);
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && lives[nr][nc] < l) {
                    queue.add(new int[] {nr, nc, dist + 1, l});
                    lives[nr][nc] = l;
                }
            }
            
        }
        
        return -1;
    }
}