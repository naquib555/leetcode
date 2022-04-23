/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        
        List<String> list = new ArrayList<>();
        
        for (String s : wordlist) list.add(s);
        
        Random random = new Random();
        
        int i = 0;
        
        while (i < 10 && !list.isEmpty()) {
            String word = list.get(random.nextInt(list.size()));
            
            int guess = master.guess(word);
            
            if (guess == word.length()) return;
            
            list.removeIf(w -> countMatch(word, w) != guess);
            i++;
        }
    }
    
    int countMatch(String s1, String s2) {
        int count = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            count += s1.charAt(i) == s2.charAt(i) ? 1 : 0;
        }
        
        return count;
    }
}