class Solution {
    public int splitArray(int[] nums, int m) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            sum += num;
        }
        
        int left = maxVal;
        int right = sum;
        
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canSplit(nums, mid, m)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    boolean canSplit(int[] nums, int largest, int m) {
        int subarrayCount = 0;
        int currSum = 0;
        
        for (int num : nums) {
            currSum += num;
            
            if (currSum > largest) {
                subarrayCount++;
                currSum = num;
            }
        }
        
        return subarrayCount + 1 <= m;
    }
}


/*
  7, 2, 5, 10, 8
  0  7  9  14 20




*/