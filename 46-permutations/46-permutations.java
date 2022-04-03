class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        ArrayList<Integer> numsList = new ArrayList<>();
        
        for (int num : nums)
            numsList.add(num);
        
        int n = nums.length;
        
        backtrack(n, numsList, result, 0);
        
        return result;
    }
    
    void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            
            backtrack(n, nums, output, first + 1);
            
            Collections.swap(nums, first, i);
        }
    }
    
    
}