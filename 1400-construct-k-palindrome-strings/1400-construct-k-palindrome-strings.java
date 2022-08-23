class Solution {
    public boolean canConstruct(String s, int k) {
        int[] arr = new int[26];
        
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        int odd = 0;
        
        for (int i : arr) {
            if (i % 2 != 0) odd++;
        }
        
        return odd <= k && k <= s.length();
    }
}