class Solution {
    public String reverseWords(String s) {
        
        int endIndex = -1;
        int i = s.length() - 1;
        
        StringBuilder result = new StringBuilder();
        
        while (i >= 0) {
            if (endIndex != -1 && s.charAt(i) == ' ') {
                result.append(s.substring(i + 1, endIndex + 1));
                endIndex = -1;
            } else if (endIndex == -1 && s.charAt(i) != ' ') {
                endIndex = i;
                if (result.length() > 0)
                    result.append(' ');
            }
            i--;
        }
        
        if (endIndex != -1)
            result.append(s.substring(0, endIndex + 1));
        return result.toString();
    }
}