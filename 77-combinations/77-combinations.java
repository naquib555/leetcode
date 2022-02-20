class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combine(int n, int k) {
        
        result = new ArrayList<>();
        
        backtrack(1, n, k, new LinkedList<>());
        
        return result;
    }
    
    void backtrack(int start, int n, int remK, LinkedList<Integer> current) {
        
        if (remK == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else if (remK < 0) return;
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i+1, n, remK - 1, current);
            current.removeLast();
        }
        
    }
}