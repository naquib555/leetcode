class Solution {
    public int lengthOfLastWord(String s) {
        
        StringBuilder lastWord = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                lastWord = new StringBuilder();
            }
            if (s.charAt(i) != ' ')
                lastWord.append(s.charAt(i));
        }
        
        return lastWord.length();
    }
}