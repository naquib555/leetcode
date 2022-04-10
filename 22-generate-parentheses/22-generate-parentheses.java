class Solution {
    List<String> result;
    int n;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        this.n = n;
        
        backtrack(0, 0, new StringBuilder());
        
        return result;
        
    }
    
    void backtrack(int open, int close, StringBuilder sb) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        
        if (open < n) {
            sb.append("(");
            backtrack(open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(")");
            backtrack(open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}