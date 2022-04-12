class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[] neighbors = {-1, 0, 1};
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int liveNeighbors = 0;
                
                for (int i = 0; i < neighbors.length; i++) {
                    for (int j = 0; j < neighbors.length; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = row + neighbors[i];
                            int c = col + neighbors[j];
                            
                            if ((r >= 0 && r < m) && (c >= 0 && c < n) && (Math.abs(board[r][c]) == 1))
                                liveNeighbors++;
                        }
                    }
                }
                
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[row][col] = -1;
                
                if (board[row][col] == 0 && liveNeighbors == 3)
                    board[row][col] = 2;
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] > 0)
                    board[row][col] = 1;
                else
                    board[row][col] = 0;
            }
        }
        
        
    }
}