class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if (nums.length == 1) return false;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            
            set.add(nums[i]);
            
            if (set.size() > k) set.remove(nums[i - k]);
        }
        
        return false;
        
        /*
    
        nums = [1,2,2,3,1], k = 3
        
        set = 1,2,2,3,1
        i=0,1,2,3
     
     
    
    
    
        */
        
        /*
        int i = 0;
        
        int j = i + 1;
        
        while (j < nums.length) {
            if (Math.abs(i - j) <= k) {
                if (nums[i] == nums[j]) return true;
                else j++;
            } else {
                i++;
                j = i + 1;
            }
        }
        return false;
        */
    }
    
    /*
    
    [1,2,6,7,2,3,1]
     0 1 2 3 4 5 6
     
     
    
    
    
    */
}