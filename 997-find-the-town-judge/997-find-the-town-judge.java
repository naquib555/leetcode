class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if (trust.length < n - 1) return -1;
        
        int[] degree = new int [n + 1];
        
        for (int[] relation : trust) {
            degree[relation[0]]--;
            degree[relation[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) return i;
        }
        
        return -1;
    }
    
    int findJudge_dfs_doesnot_work(int n, int[][] trust) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < trust.length; i++) {
            graph[trust[i][0]].add(trust[i][1]);
        }
        
        boolean[] visited = new boolean[n + 1];
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        visited[1] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (graph[current].size() == 0) return current;
            
            for (Integer neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.add(neighbor);
                }
            }
        }
        return -1;
    }
}

/*
[1,2],[2,3]

1 -> 3
2 -> 3
3 ->
[1,3],[2,3],[3,1]
1->3
2->3
3->1
*/