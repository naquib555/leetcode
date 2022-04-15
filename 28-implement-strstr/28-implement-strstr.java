class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        
        int h = 0;
        
        while (h < haystack.length()) {
            int n = 0;
            int tempH = h;
            while (n < needle.length() && tempH < haystack.length() && haystack.charAt(tempH) == needle.charAt(n)) {
                n++;
                tempH++;
            }
            if (n == needle.length()) return h;
            
            h++;
        }
        return -1;
    }
}