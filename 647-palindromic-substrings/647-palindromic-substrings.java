class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            count += countPalindrome(left, right, s);
        }
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + 1;
            count += countPalindrome(left, right, s);
        }
        return count;
        
    }
    
    int countPalindrome(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    
    /*
    aabbaeef
    1
    2
    */
}