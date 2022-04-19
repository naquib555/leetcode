class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        
        int p1 = 0;
        int p2 = 0;
        
        int slen = start.length();
        int elen = end.length();
        
        while (p1 < slen && p2 < elen) {
            while (p1 < slen && start.charAt(p1) == 'X')
                p1++;
            while (p2 < elen && end.charAt(p2) == 'X')
                p2++;
            
            if (p1 == slen && p2 == elen)
                return true;
            
            if (p1 == slen || p2 == elen)
                return false;
            
            if (start.charAt(p1) != end.charAt(p2))
                return false;
            
            if (start.charAt(p1) == 'L' && p2 > p1)
                return false;
            
            if (end.charAt(p2) == 'R' && p1 > p2)
                return false;
            
            p1++;
            p2++;
        }
        
        return true;
    }
}