class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        
        int mismatch = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else mismatch++;
            }
        }
        return (mismatch + 1) / 2;
    }
}