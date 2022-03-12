class Solution {
    List<Integer> result;
    List<List<Integer>> graph;
    Set<Integer> currentVisited;
    boolean[] visited;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        result = new ArrayList<>();
        
        graph = new ArrayList<>();
        
        currentVisited = new HashSet<>();
        
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        
        for (int[] p : prerequisites) {
            graph.get(p[0]).add(p[1]);
        }
        
        visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if(!dfs(i)) return new int[]{};
            }
        }
        
        int[] finalResult = new int[result.size()];
        
        for (int i = 0; i < finalResult.length; i++)
            finalResult[i] = result.get(i);
        
        return finalResult;
        
    }
    
    boolean dfs(int node) {
        if (!visited[node]) {
            visited[node] = true;
            currentVisited.add(node);
            
            for (Integer child : graph.get(node)) {
                if (currentVisited.contains(child)) return false;
                if (!visited[child])
                    if(!dfs(child)) return false;
            }
            currentVisited.remove(node);
            result.add(node);
            
        }
        return true;
    }
}

/*
[1,0],[2,0],[3,1],[3,2]

[0,1,2,3]

0-1
0-2
1-3
3-2

0->
1-> 0
2-> 3
3-> 2
4-> 1

0 -> 1,2
1 -> 3
3 -> 2

0 1 3

0 -- 1 -- 2
     --3--    
*/