class Solution {
    public int findShortestSubArray(int[] nums) {
        int result = Integer.MAX_VALUE;
        
        int maxFreq = -1;
        
        Map<Integer, Integer> freqCount = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int freq = freqCount.getOrDefault(nums[i], 0) + 1;
            
            freqCount.put(nums[i], freq);
            maxFreq = Math.max(maxFreq, freq);
            
            if (left.get(nums[i]) == null)
                left.put(nums[i], i);
            right.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (freqCount.get(nums[i]) == maxFreq) {
                result = Math.min(result, right.get(nums[i]) - left.get(nums[i]) + 1);
            }
        }
        
        return result;
    }
}

class DegreeDt {
    int freq;
    int firstIndex;
    int lastIndex;
    
    
}