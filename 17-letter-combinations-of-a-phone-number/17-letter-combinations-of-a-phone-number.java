class Solution {
    
    List<String> result;
    String digits;
    private Map<Character, String> phone = Map.of('2', "abc", '3', "def", 
                                                  '4', "ghi", '5', "jkl", '6', "mno", 
                                                  '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        
        result = new ArrayList<>();
        this.digits = digits;
        
        if (digits.length() == 0) return result;
        
        backtrack(0, new StringBuilder());
        
        return result;
    }
    
    public void backtrack(int index, StringBuilder path) {
        
        if (digits.length() == path.length()) {
            result.add(path.toString());
            return;
        }
        
        String letters = phone.get(digits.charAt(index));
        
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

/*
2 = abc
3 = def

ad ae af

*/