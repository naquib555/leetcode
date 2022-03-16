class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int n = popped.length;
        
        int i = 0;
        
        for (int push : pushed) {
            stack.push(push);
            
            while (!stack.isEmpty() && i < n && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        
        return i == n;
    }
}

/*
1,2,3,4,5
4,5,3,2,1

4,3,5,1,2

stack=1,2
4

*/