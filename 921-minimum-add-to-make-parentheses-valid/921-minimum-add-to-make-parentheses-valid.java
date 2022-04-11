class Solution {
    public int minAddToMakeValid(String s) {
        int bal = 0;
        
        int mismatch = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                bal++;
            else {
                if (bal > 0)
                    bal--;
                else mismatch++;
            }
        }
        return bal + mismatch;
    }
}