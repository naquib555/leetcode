class Solution {
    public String longestPalindrome(String s) {
        
        int longPal = 0;
        StringBuilder pal = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            
            pal = countPalindrome(left, right, s, 0, pal);
        }
        
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + 1;
            
            pal = countPalindrome(left, right, s, 2, pal);
        }
        
        return pal.toString();
        
    }
    
    StringBuilder countPalindrome(int left, int right, String s, int count, StringBuilder pal) {
        StringBuilder sb = new StringBuilder();
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == right)
                sb.append(s.charAt(left));
            else {
                sb.insert(0, s.charAt(left));
                sb.append(s.charAt(right));
            }
            left--;
            right++;
        }
        
        if (sb.toString().length() > pal.toString().length()) 
            pal = sb;
        
        return pal;
    }
    
    //babad
    
    /*
    
    
    */
}