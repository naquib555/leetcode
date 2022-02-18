class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(s.length()-1-j)) {
                    dp[j][i] = 1 + dp[j+1][i+1];
                } else {
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i+1]);
                }
            }
        }
        return dp[0][0];
    }
    
    /*
          b a b b b
        b 4 3 3 2 1 0  
        b 3 3 3 2 1 0
        b 3 2 2 2 1 0
        a 2 2 1 1 1 0
        b 1 1 1 1 1 0
          0 0 0 0 0 0
          
    */
}