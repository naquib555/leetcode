class Solution {
    HashMap<Integer, Integer> dp;
    int result;
    
    public int numDecodings(String s) {
        dp = new HashMap<>();
        
        dp.put(s.length(), 1);
        
        result = 0;
        
        return dfs(0, s);
        
    }
    
    int dfs(int i, String s) {
        if (dp.containsKey(i))
            return dp.get(i);
        if (s.charAt(i) == '0')
            return 0;
        
        result += dfs(i + 1, s);
        
        if (i + 1 < s.length() && (s.charAt(i) == '1' 
                                   || (s.charAt(i) == '2' && s.charAt(i + 1) - '0' <= 6)))
            result += dfs(i + 2, s);
        dp.put(i, result);
        
        return result;
    }
}