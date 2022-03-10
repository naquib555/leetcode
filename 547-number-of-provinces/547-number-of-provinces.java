class Solution {
    int[] parent;
    int[] rank;
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        parent = new int[n];
        
        for (int i = 0; i < n; i++)
            parent[i] = i;
        
        rank = new int[n];
        Arrays.fill(rank, 1);
        
        int noOfProvinces = n;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    noOfProvinces -= union(i, j);
                }
            }
        }
        
        return noOfProvinces;
    }
    
    int find(int n1) {
        int res = n1;
        
        while (parent[res] != res) {
            parent[res] = parent[parent[res]];
            res = parent[res];
        }
        
        return res;
    }
    
    int union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if (p1 == p2) return 0;
        
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        
        return 1;
    }
}