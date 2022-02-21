class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        
        Map<Integer, Integer> counter = new HashMap<>();
        
        for(int num : candidates)
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        
        List<int[]> counterList = new ArrayList<>();
        
        counter.forEach((key, value) -> {
            counterList.add(new int[] {key, value});
        });
        
        backtrack(counterList, target, 0, new LinkedList<>());
        
        return result;
        
    }
    
    void backtrack(List<int[]> candidatesCounter, int rem, int start, 
                   LinkedList<Integer> current) {
        
        if (rem == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else if (rem < 0) return;
        
        
        for (int i = start; i < candidatesCounter.size(); i++) {
            
            int[] entry = candidatesCounter.get(i);
            
            int candidate = entry[0];
            int count = entry[1];
            
            if(count > 0) {
                current.addLast(candidate);
                candidatesCounter.set(i, new int[] {candidate, count-1});
                
                backtrack(candidatesCounter, rem - candidate, i, current);
                
                candidatesCounter.set(i, new int[] {candidate, count});
                current.removeLast();
            }
        }
        
    }
    
    /*
    [10,1,2,7,6,1,5] 8
    
    [10,1,2,7,6,1,5]
    10->1
    1->2/1
    2->1/0
    7->1
    6->1
    5->1/0/1
    
    1,1,6
    
    
    */
}