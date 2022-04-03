class Solution {
    public String reverseStr(String s, int k) {
        
        StringBuilder sb = new StringBuilder(s);
        
        for (int start = 0; start < sb.length(); start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, s.length() - 1);
            
            while (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                
                i++;
                j--;
            }
        }
        
        return sb.toString();
    }
}