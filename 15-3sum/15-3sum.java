class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1])
                twoSum(nums, i);
        }
        
        return result;
    }
    
    public void twoSum(int[] nums, int i) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int j = i + 1; j < nums.length; j++) {
            int currSum = nums[i] + nums[j];
            
            if (map.containsKey(currSum * -1)) {
                result.add(Arrays.asList(nums[i], nums[j], nums[map.get(currSum * -1)]));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    j++;
            }
            
            map.put(nums[j], j);
        }
    }
}