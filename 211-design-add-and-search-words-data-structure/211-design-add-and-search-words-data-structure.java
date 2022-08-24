class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return searchInNode(word, root, 0);
    }
    
    public boolean searchInNode(String word, TrieNode node, int i) {
        
            if (i == word.length()) return node.isEnd();
        
            char c = word.charAt(i);
            
            if (c == '.') {
                for (TrieNode child : node.getLinks()) {
                    if (child != null && searchInNode(word, child, i + 1))
                        return true;
                }
                return false;
            } else if (node.containsKey(c))
                return searchInNode(word, node.get(c), i + 1);
             else return false;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class TrieNode {
    private TrieNode[] links;
    
    private int R = 26;
    
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    
    public TrieNode get(char c) {
        return links[c - 'a'];
    }
    
    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public TrieNode[] getLinks() {
        return links;
    }
    
}