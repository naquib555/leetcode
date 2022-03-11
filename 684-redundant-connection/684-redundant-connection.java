class Solution {
    int [] parent;
    int [] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        rank = new int[n + 1];
        Arrays.fill(rank, 1);
        
        for (int [] edge : edges) {
            if (!union(edge[0], edge[1])) return edge;
        }
        return new int[]{-1, -1};
        
    }
    
    int find(int node) {
        int res = node;
        
        while (parent[res] != res) {
            parent[res] = parent[parent[res]];
            res = parent[res];
        }
        
        return res;
    }
    
    boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if (p1 == p2) return false;
        
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        
        return true;
    }
}