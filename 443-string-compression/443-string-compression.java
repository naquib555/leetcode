class Solution {
    public int compress(char[] chars) {
        
        int index = 0;
        int size = 0;
        
        while (index < chars.length) {
            char curr = chars[index];
            
            int count = 0;
            
            while (index < chars.length && curr == chars[index]) {
                index++;
                count++;
            }
            
            chars[size++] = curr;
            
            if (count != 1) {
                String s = String.valueOf(count);
                for (int i = 0; i < s.length(); i++)
                    chars[size++] = s.charAt(i);
            }
        }
        
        return size;
    }
}