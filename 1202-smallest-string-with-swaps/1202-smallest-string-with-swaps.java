class Solution {
    
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        for (List<Integer> pair : pairs) {
            adjList.computeIfAbsent(pair.get(0), a -> new ArrayList<>()).add(pair.get(1));
            adjList.computeIfAbsent(pair.get(1), a -> new ArrayList<>()).add(pair.get(0));
        }
        
        char[] result = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            if (!visited.contains(i)) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                
                dfs(i, characters, indices, s);
                
                Collections.sort(characters);
                Collections.sort(indices);
                
                for (int index = 0; index < characters.size(); index++) {
                    result[indices.get(index)] = characters.get(index);
                }
            }
        }
        
        return new String(result);
    }
    //d b a c
    //0 3 2 1
    //a b c d
    //0 1 2 3
    void dfs(int vertex, List<Character> characters, List<Integer> indices, String s) {
        characters.add(s.charAt(vertex));
        indices.add(vertex);
        
        visited.add(vertex);
        
        for (int adj : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(adj))
                dfs(adj, characters, indices, s);
        }
    }
}

/*
s = "dcab", pairs = [[0,3],[1,2],[0,2]]
dcab
*/