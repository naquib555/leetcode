class Solution {
    public boolean checkRecord(String s) {
        int abs = 0;
        int late = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                abs++;
                late = 0;
            } else if (s.charAt(i) == 'L')
                late++;
            else late = 0;
            
            if (abs >= 2 || late >= 3)
                return false;
        }
        
        return true;
    }
}