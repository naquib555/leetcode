class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = 0;
        
        int fast = 0;
        
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if (slow == fast) break;
        }
        
        int secondSlow = 0;
        
        while (true) {
            slow = nums[slow];
            secondSlow = nums[secondSlow];
            
            if (slow == secondSlow) return slow;
        }
    }
    
    /*
     0 1 2 3 4 5
    [3,1,4,2,2,5]
    0-->3--4<-->2
    slow = nums[nums[i]]
    fast = nums[nums[nums[i]]]
    
    0   3
    1   1
    2   -4
    3   -2
    4   
    5
    
    
    
    
    
    
    */
}