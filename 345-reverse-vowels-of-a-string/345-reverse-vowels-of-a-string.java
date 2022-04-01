class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder("aeiouAEIOU");
        
        int n = s.length();
        
        int left = 0;
        int right = n - 1;
        
        StringBuilder result = new StringBuilder(s);
        while (left < right) {
            if (vowels.indexOf(String.valueOf(result.charAt(left))) != -1 
                && vowels.indexOf(String.valueOf(result.charAt(right))) != -1) {
                
                char temp = result.charAt(left);
                result.replace(left, left + 1, String.valueOf(result.charAt(right)));
                result.replace(right, right + 1, String.valueOf(temp));
                
                left++;
                right--;
            }
            if (vowels.indexOf(String.valueOf(s.charAt(left))) == -1) left++;
            if (vowels.indexOf(String.valueOf(s.charAt(right))) == -1) right--;
        }
        
        return result.toString();
    }
}