class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        
        int index = -1;
        int totalResult = 0;
        boolean foundTarget = false;
        for(int num : nums) {
            if(num < target) {
                index++;
            } else if(num == target) totalResult++;
        }
        
        for(int i = 0; i < totalResult; i++) {
            result.add(++index);
        }
        return result;
    }
}