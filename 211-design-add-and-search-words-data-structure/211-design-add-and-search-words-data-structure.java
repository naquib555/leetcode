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
        return searchInNode(word, root);
    }
    
    public boolean searchInNode(String word, TrieNode node) {
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!node.containsKey(c)) {
                if (c == '.') {
                    for (int j = 0; j < node.getLinks().length; j++) {
                        if (node.getLinks()[j] != null) {
                            TrieNode child = node.getLinks()[j];
                            if (searchInNode(word.substring(i + 1), child))
                                return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.get(c);
            }
        }
        return node.isEnd();
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
    
    public boolean isWithinLimit(char c) {
        return c - 'a' >= 0 && c - 'a' < 26;
    }
    
    public boolean containsKey(char c) {
        return isWithinLimit(c) && links[c - 'a'] != null;
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