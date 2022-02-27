class Solution {
    public boolean isValid(String s) {
        
        if (s.length() < 2) return false;
        
        Map<Character, Character> brackets = new HashMap<>();
        
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))) {
                if (stack.isEmpty()) return false;
                
                if (stack.peek() != brackets.get(s.charAt(i))) return false;
                else stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty() ? true : false;
        
        
    }
}