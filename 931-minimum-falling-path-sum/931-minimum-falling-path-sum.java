class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int[] directions = {-1, 0, 1};
        
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int minValue = Integer.MAX_VALUE;
                for (int i = 0; i < directions.length; i++) {
                    int r = row - 1;
                    int c = col + directions[i];
                    
                    if (c >= 0 && c < n) {
                        minValue = Math.min(minValue, matrix[row][col] + matrix[r][c]);
                    }
                }
                matrix[row][col] = minValue;
                
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        for (int col = 0; col < n; col++) {
            result = Math.min(result, matrix[n - 1][col]);
        }
        
        return result;
    }
}