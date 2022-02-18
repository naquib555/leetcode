class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        
        for (int i = text2.length()-1; i >= 0; i--) {
            for (int j = text1.length()-1; j >= 0; j--) {
                if(text1.charAt(j) == text2.charAt(i)) {
                   dp[j][i] = 1 + dp[j+1][i+1];
                } else {
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i+1]);
                }
            }
            
        }
        
        return dp[0][0];
    }
    
    /*
        a c e
      b 0 0 0 0
      a 1 0 0 0
      b 0 0 0 0
      c 0 1 0 0
      d 0 0 0 0
      e 0 0 1 0
        0 0 0 0
    */
}