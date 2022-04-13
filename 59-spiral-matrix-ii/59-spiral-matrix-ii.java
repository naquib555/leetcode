class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int count = 0;
        
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            for (int i = layer; i < n - layer; i++) {
                matrix[layer][i] = ++count;
            }
            
            for (int i = layer + 1; i < n - layer; i++) {
                matrix[i][n - layer - 1] = ++count;
            }
            
            for (int i = layer + 1; i < n - layer; i++) {
                matrix[n - layer - 1][n - i - 1] = ++count;
            }
            
            for (int i = layer + 1; i < n - layer -1; i++) {
                matrix[n - i - 1][layer] = ++count;
            }
        }
        
        return matrix;
    }
}