class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        int sLen = s.length();
        int pLen = p.length();
        
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        
        for (int i = 0; i < pLen; i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            
            if (i >= pLen) {
                c = s.charAt(i - pLen);
                
                if (sCount.get(c) == 1) {
                    sCount.remove(c);
                } else {
                    sCount.put(c, sCount.get(c) - 1);
                }
            }
            
            if (pCount.equals(sCount)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
}

/*
cbaebabacd

*/