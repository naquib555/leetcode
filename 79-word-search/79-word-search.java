class Solution {
    private char[][] board;
    int rows;
    int cols;
    
    private int[] rowDir = {0, 1, 0, -1};
    private int[] colDir = {1, 0, -1, 0};
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    boolean backtrack(int i, int j, String word, int index) {
        
        if (index >= word.length()) return true;
        
        if (i < 0 || j < 0 || i >= rows || j >= cols 
            || board[i][j] != word.charAt(index)) {
            
            return false;
        }
        
        boolean result = false;
        
        board[i][j] = '#';
        
        for (int d = 0; d < 4; d++) {
            result = backtrack(i + rowDir[d], j + colDir[d], word, index + 1);
            
            if (result) break;
        }
        
        board[i][j] = word.charAt(index);
        
        return result;
        
    }
}