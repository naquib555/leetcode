class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] dp = new long[n];
        
        long[] left = new long[n];
        long[] right = new long[n];
        
        long result = 0;
        
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                int k = 0;
                while (k < n) {
                    dp[k] = points[0][k++];
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0)
                        left[j] = dp[j];
                    else
                        left[j] = Math.max(left[j - 1] - 1, dp[j]);
                }

                for (int j = n - 1; j > -1; j--) {
                    if (j == n - 1)
                        right[j] = dp[j];
                    else
                        right[j] = Math.max(right[j + 1] - 1, dp[j]);
                }

                for (int j = 0; j < n; j++) {
                    dp[j] = points[i][j] + Math.max(left[j], right[j]);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            result = Math.max(result, dp[j]);
        }
        return result;
    }
    public long maxPoints_old(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[][] dp = new long[m][n];
        
        long result = 0;
        
        for (int col = 0; col < n; col++) {
            dp[0][col] = points[0][col];
            result = Math.max(result, dp[0][col]);
        }
        
        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int k = 0;
                while (k < n) {
                    dp[r][c] = Math.max(dp[r][c], points[r][c] + dp[r - 1][k] - Math.abs(c - k));
                    k++;
                }
                
                result = Math.max(result, dp[r][c]);
            }
        }
        return result;
    }
}

/*
r c1

maxVal + (r + 1, c2) - (c1 - c2)
*/