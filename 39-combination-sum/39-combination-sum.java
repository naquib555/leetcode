class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        backtrack(0, candidates, target, new LinkedList<>());
        
        return result;
    }
    
    void backtrack(int start, int[] candidates, int rem, LinkedList<Integer> current) {
        if(rem == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else if (rem < 0) return;
        for (int i = start; i < candidates.length; i++) {
            
            current.add(candidates[i]);
            backtrack(i, candidates, rem - candidates[i], current);
            current.removeLast();
            
        }
    }
    
    //2,3,6,7
    /*
    [2] []
    [2] -> [2, 2] -> [2, 2, 2]
    */
    
}