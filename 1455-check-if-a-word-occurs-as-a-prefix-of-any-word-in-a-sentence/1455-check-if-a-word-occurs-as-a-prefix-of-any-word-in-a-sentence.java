class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] input = sentence.split(" ");
        
        int result = 0;
        
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() >= searchWord.length() && input[i].startsWith(searchWord, 0)) {
                return i + 1;
            }
        }
        return -1;
    }
}