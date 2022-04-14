class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Pair<String, Integer>>[] list = new ArrayList[26];
        
        int result = 0;
        
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (String word : words) {
            list[word.charAt(0) - 'a'].add(new Pair<String, Integer>(word, 0));
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ArrayList<Pair<String, Integer>> oldBucket = list[c - 'a'];
            
            list[c - 'a'] = new ArrayList<>();
            
            for (Pair<String, Integer> pair : oldBucket) {
                Pair<String, Integer> p = new Pair(pair.getKey(), pair.getValue() + 1);
                
                if (p.getValue() == p.getKey().length())
                    result++;
                else 
                    list[p.getKey().charAt(p.getValue()) - 'a'].add(p);
            }
            oldBucket.clear();
        }
        
        return result;
    }
    
    
}