class Solution {
    public int countBinarySubstrings(String s) {
        
        int result = 0;
        
        int prevCount = 0;
        int currCount = 1;
        
        for (int i = 1; i < s.length(); i++) {
            
            if (s.charAt(i - 1) == s.charAt(i)) {
                currCount++;
            } else {
                if (prevCount != 0) {
                    result += Math.min(currCount, prevCount);
                }
                prevCount = currCount;
                currCount = 0;
                currCount++;
            }
        }
        result += Math.min(currCount, prevCount);
        return result;
    }
}

/*
00 11 00 11
2  2  2  2

*/