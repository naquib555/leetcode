class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        
        int sI = 0, tI = 0;
        
        while (sI < s.length() && tI < t.length()) {
            if (s.charAt(sI) == t.charAt(tI)) {
                sI++;
                tI++;
            } else tI++;
        }
        
        return sI == s.length();
    }
}