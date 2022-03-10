class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(source);
        visited[source] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (current == destination) return true;
            
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.add(neighbor);
                }
            }
        }
        return false;
    }
}

/*
0 1 2 3 4 5
[0,1]
[0,2]
[3,5]
[5,4]
[4,3]
*/