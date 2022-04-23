class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++)
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        
        List<Integer> curr = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        curr.add(0);
        
        int result = 0;
        
        while (!curr.isEmpty()) {
            List<Integer> nex = new LinkedList<>();
            
            for (int node : curr) {
                if (node == n - 1) {
                    return result;
                }
                
                for (int child : graph.get(arr[node])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nex.add(child);
                    }
                }
                
                graph.get(arr[node]).clear();
                    
                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    nex.add(node + 1);
                }
                
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    nex.add(node - 1);
                }
            }
            
            curr = nex;
            result++;
            
        }
        
        return -1;
        
    }
}

/*
0    1   2   3   4  5  6  7  8  9
100,-23,-23,404,100,23,23,23,3,404

100 = 0,4
-23 = 1,2
404 = 3,9
23 = 5, 6, 7
3 = 8

visited = 0, 4, 1

curr = 0, 4, 1
nex = 

*/