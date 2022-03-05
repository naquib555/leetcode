class Solution {
    public String decodeString(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            Character value = s.charAt(i);
            if (value == ']') {
                
                List<Character> decodedString = new ArrayList<>();
                
                while (!stack.isEmpty() && stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                
                stack.pop();
                
                int k = 0;
                int base = 1;
                
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
                if (!stack.isEmpty()) {
                    for (int j = sb.toString().length() - 1; j >=0; j--) {
                        stack.push(sb.toString().charAt(j));
                    }
                    sb = new StringBuilder();
                }
            } else stack.push(value);
        }
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
        
    }
}

/*
3[a2[c]]

if the digit is number start inserting into stack
stack: 3 [ a 

cc

3[a]2[bc]
stack: 3 [ a

*/