class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            int result = 0;
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                if (token.equals("+"))
                    result = num1 + num2;
                else if (token.equals("-"))
                    result = num1 - num2;
                else if (token.equals("*"))
                    result = num1 * num2;
                else if (token.equals("/"))
                    result = num1 / num2;
                
                stack.push(result);
            } else stack.push(Integer.valueOf(token));
        }
        
        return stack.pop();
    }
}