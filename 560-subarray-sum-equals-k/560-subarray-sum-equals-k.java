class Solution {
    
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
        
    }
    public int subarraySum_old(int[] nums, int k) {
        int result = 0;
        
        int current = nums[0];
        
        int left = 0;
        int right = 1;
        
        while (left < right && right < nums.length) {
            
            if (current == k) {
                result++;
                current -= nums[left];
                left++;
            } else if(current < k) {
                right++;
            } else {
                left++;
                right++;
            }
            
            current += nums[right];
        }
        
        return result;
    }
}
/*
[8,2,3,3,5,6] 6
1+2+3=6 2+3=5
2+3+3=8 3+3=6

[1,2,3] 3
sum = 1,3=3=2




*/