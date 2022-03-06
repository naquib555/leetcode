class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> map = new HashMap<>();
        
        int longSeq = 1;
        
        for (String word : words) {
            int presentLength = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int prevLength = map.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, prevLength + 1);
            }
            map.put(word, presentLength);
            longSeq = Math.max(longSeq, presentLength);
        }
        return longSeq;
    }
}

/*
["a","ba","bda","bdca"]

prev
current

current - prev > 1 break



*/