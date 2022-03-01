class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        
        int i = 0;
        int j = 0;
        
        while (result.size() < m * n) {
            
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            
            if (up != down) {
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }
            
            if (left != right) {
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            
            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
    
    /*
    
        0   1   2   3
    0   1   2   3   4
    1   5   6   7   8
    2   9   10  11  12
    
    
    left = 0
    top = 0
    right = n
    down = m
    
    
    matrix[i][j]
    
    */
}