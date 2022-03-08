class Solution {

    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        int[] randomNums = new int[nums.length];
        
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = nums[i];
        }
        
        for (int i = 0; i < randomNums.length; i++) {
            int randomIndex = i + random.nextInt(randomNums.length - i);
            
            int temp = randomNums[randomIndex];
            randomNums[randomIndex] = randomNums[i];
            randomNums[i] = temp;
        }
        
        return randomNums;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
