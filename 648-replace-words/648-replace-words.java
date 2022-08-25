class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        
        for (String word : dictionary) {
            trie.add(word);
        }
        
        StringBuilder sb = new StringBuilder();
        
        String[] sentenceArray = sentence.split(" ");
        for (int i = 0; i < sentenceArray.length; i++) {
            String prefix = trie.getPrefix(sentenceArray[i]);
            if (prefix != null)
                sb.append(prefix);
            else sb.append(sentenceArray[i]);
            
            if (i != sentenceArray.length - 1)
                sb.append(" ");
        }
        
        return sb.toString();
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void add(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.links.containsKey(c)) {
                node.links.put(c, new TrieNode());
            }
            node = node.links.get(c);
        }
        node.setWord(word);
    }
    
    public String getPrefix(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.links.containsKey(c)) {
                
                if (node.links.get(c).getWord() == null)
                    node = node.links.get(c);
                else {
                    return node.links.get(c).getWord();
                }
            } else {
                return null;
            }
        }
        return node.getWord();
    }
}

class TrieNode {
    Map<Character, TrieNode> links;
    
    private String word;
    
    public TrieNode() {
        links = new HashMap<>();
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public String getWord() {
        return word;
    }
    
    public String toString() {
        return this.word + "->" + links.toString();
    }
}