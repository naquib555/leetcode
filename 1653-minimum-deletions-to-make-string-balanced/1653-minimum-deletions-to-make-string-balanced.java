class Solution {
    public int minimumDeletions(String s) {
        
        int bCount = 0;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else if (bCount > 0) {
                bCount--;
                result++;
            }
        }
        
        return result;
        
        
    }
}