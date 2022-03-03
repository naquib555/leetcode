class Solution {
    Map<Integer, List<Integer>> preMap;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visited = new HashSet<>();
        
        for (int[] pre : prerequisites) {
            List<Integer> neighbors = new ArrayList<>();
            
            if (preMap.containsKey(pre[0])) {
                neighbors = preMap.get(pre[0]);
            }
            neighbors.add(pre[1]);
            
            preMap.put(pre[0], neighbors);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }
    
    boolean dfs(int course) {
        if (visited.contains(course)) return false;
        
        if (preMap.get(course) == null || preMap.get(course).size() == 0) return true;
        
        visited.add(course);
        
        for (Integer pre : preMap.get(course)) {
            if (!dfs(pre)) return false;
        }
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
/* 
    
      0 1
   0  1 0
   1  0 1
*/