class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int a = i; a < matrix.length; a++) {
                    for (int b = j; b < matrix[0].length; b++) {
                        int curr_sum = sum[a+1][b+1] - sum[i][b+1] - sum[a+1][j] + sum[i][j];
                        if (curr_sum <= k && curr_sum > ans) {
                            ans = curr_sum;
                        }
                    }
                }
            }
        }
        return ans;
    }
}