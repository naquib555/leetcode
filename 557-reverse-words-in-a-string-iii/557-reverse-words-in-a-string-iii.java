class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringBuilder result = new StringBuilder();
        
        for (int w = 0; w < words.length; w++) {
            
            int i = 0;
            int j = words[w].length() - 1;
            
            StringBuilder sb = new StringBuilder(words[w]);
            
            while (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
            
            if (w != words.length - 1) sb.append(" ");
            
            result.append(sb.toString());
        }
        
        return result.toString();
    }
}