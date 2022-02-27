class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            
            if (count == 0) return false;
            
            count--;
            
            if (count >= 1) map.put(t.charAt(i), count);
            else map.remove(t.charAt(i));
        }
        return map.size() > 0 ? false : true;
    }
    
    /*
    s = "anagram", t = "nagaram"
    
    HashMap
    a->3
    n->1
    g->1
    r->1
    m->1
    */
}