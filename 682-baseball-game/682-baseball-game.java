class Solution {
    public int calPoints(String[] ops) {
        int prevScore = 0;
        int currScore = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int result = 0;
        
        for (String s : ops) {
            if (s.equals("C")) {
                result -= stack.pop();
            } else if (s.equals("D")) {
                int val = stack.peek() * 2;
                result += val;
                stack.push(val);
            } else if (s.equals("+")) {
                int temp = stack.pop();
                int val = temp + stack.peek();
                stack.push(temp);
                stack.push(val);
                result += val;
            } else {
                int val = Integer.parseInt(s);
                result += val;
                stack.push(val);
            }
        }
        
        return result;
    }
}