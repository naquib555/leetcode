class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (count.containsKey(nums[i] - k))
                result += count.get(nums[i] - k);
            
            if (count.containsKey(nums[i] + k))
                result += count.get(nums[i] + k);
            
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        return result;
    }
}