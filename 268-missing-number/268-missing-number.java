class Solution {
    public int missingNumber(int[] nums) {
        
        int actualSum = (nums.length * (nums.length + 1)) / 2;
        
        int sumOfNums = 0;
        for (int num : nums) sumOfNums += num;
        
        return actualSum - sumOfNums;
        
    }
    
    /*
    0 1 2 3 4 5 6 7 8
    9,6,4,2,3,5,7,0,1
    
    0 1 2 3 4 5 6 7 8
    0 1 2 3 4 5 6 7 9
    */
}