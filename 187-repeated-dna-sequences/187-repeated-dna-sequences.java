class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        if (s.length() < 10) return new ArrayList<String>();
        
        int left = 0;
        
        HashSet<String> dnaStore = new HashSet<>();
        HashSet<String> dup = new HashSet<>();
        
        while (left < s.length() - 10 + 1) {
            StringBuilder sb = new StringBuilder(s.substring(left, left + 10));
            
            if (dnaStore.contains(sb.toString()))
                dup.add(sb.toString());
            else dnaStore.add(sb.toString());
            
            left++;
        }
        
        return new ArrayList(dup);
    }
}