class Solution {
    int count;
    public int maximumDetonation(int[][] bombs) {
        
        int ans = 0;
        
        int n = bombs.length;
        
        for (int i = 0; i < n; i++) {
            count = 0;
            dfs(bombs, new boolean[n], i, n);
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
    
    void dfs(int[][] bombs, boolean[] visited, int node, int n) {
        count++;
        
        visited[node] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && inRange(bombs[node], bombs[i])) {
                visited[i] = true;
                dfs(bombs, visited, i, n);
            }
        }
        
    }
    
    boolean inRange(int[] a, int[] b) {
        long x = a[0] - b[0];
        long y = a[1] - b[1];
        long r = a[2];
        
        return x * x + y * y <= r * r;
    }
}