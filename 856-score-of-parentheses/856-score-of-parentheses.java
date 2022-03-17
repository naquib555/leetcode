class Solution {
/*
"(()(()))"

00
 ((
000
 (()
01
03
0106
*/
    public int scoreOfParentheses(String s) {
        int result = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(0);
            else {
                int l1 = stack.pop();
                int l2 = stack.pop();
                stack.push(l2 + Math.max(2 * l1, 1));
            }
        }
        return stack.pop();
    }
    
    public int scoreOfParentheses_old_logic(String s) {
        int result = 0;
        
        Stack<Character> stack = new Stack<Character>();
        
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(s.charAt(i));
            if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                result++;
            }
        }
        return result;
    }
}
/*
(((
*/