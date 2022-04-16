class Solution {
    public String replaceDigits(String s) {
        
        StringBuilder result = new StringBuilder(s);
        
        for (int i = 0; i < s.length() && i + 1 < s.length(); i += 2) {
            char alphabet = s.charAt(i);
            char num = s.charAt(i + 1);
            
            char newAlphabet = (char) (alphabet + (num - '0'));
            
            result.setCharAt(i + 1, newAlphabet);
        }
        
        return result.toString();
    }
}