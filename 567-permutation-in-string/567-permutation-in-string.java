class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();
        
        int s1Len = s1.length();
        int s2Len = s2.length();
        
        for (int i = 0; i < s1Len; i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < s2Len; i++) {
            char c = s2.charAt(i);
            
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
            
            if (i >= s1Len) {
                c = s2.charAt(i - s1Len);
                
                if (s2Count.get(c) == 1)
                    s2Count.remove(c);
                else
                    s2Count.put(c, s2Count.get(c) - 1);
            }
            
            if (s1Count.equals(s2Count))
                return true;
        }
        
        return false;
        
        
    }
}