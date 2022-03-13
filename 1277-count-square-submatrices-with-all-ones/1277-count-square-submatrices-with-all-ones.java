class Solution {
    public int countSquares(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int result = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) {
                    if (r == 0 || c == 0)
                        result++;
                    else {
                        int cellValue = Math.min(matrix[r][c - 1], matrix[r - 1][c]);
                        cellValue = Math.min(cellValue, matrix[r - 1][c - 1]);
                        cellValue += matrix[r][c];
                        result += cellValue;
                        matrix[r][c] = cellValue;
                    }
                }
            }
        }
        return result;
    }
}