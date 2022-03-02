class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char digit = s.charAt(i);
            int index = sb.indexOf(String.valueOf(digit));
            
            if (index != -1) {
                sb.delete(0, index+1);
            }
            
            sb.append(digit);
            maxLength = Math.max(maxLength, sb.length());
            
        }
        
        return maxLength;
        
    }
}