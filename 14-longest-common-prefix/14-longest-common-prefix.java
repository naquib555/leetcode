class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        if (prefix.length() == 0) return "";
        
        for (int i = 1; i < strs.length; i++) {
            int n = Math.min(prefix.length(), strs[i].length());
            
            int j = 0;
            StringBuilder tempPrefix = new StringBuilder();
            
            while (j < n && prefix.charAt(j) == strs[i].charAt(j)) {
                tempPrefix.append(prefix.charAt(j++));
            }
            prefix = tempPrefix.toString();
            
            if (prefix.length() == 0) return "";
        }
        
        return prefix;
    }
}