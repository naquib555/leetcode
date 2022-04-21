class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int turn = 0;
        
        int[] rows = new int[3];
        int[] cols = new int[3];
        
        int diag = 0;
        int antiDiag = 0;
        
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r].charAt(c) == 'X') {
                    turn++;
                    rows[r]++;
                    cols[c]++;
                    
                    if (r == c)
                        diag++;
                    
                    if (r + c == 2)
                        antiDiag++;
                } else if (board[r].charAt(c) == 'O') {
                    turn--;
                    rows[r]--;
                    cols[c]--;
                    
                    if (r == c)
                        diag--;
                    
                    if (r + c == 2)
                        antiDiag--;
                }
            }
        }
        
        boolean xWins = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 || 
               cols[0] == 3 || cols[1] == 3 || cols[2] == 3 || 
               diag == 3 || antiDiag == 3;
        boolean oWins = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 || 
               cols[0] == -3 || cols[1] == -3 || cols[2] == -3 || 
               diag == -3 || antiDiag == -3;
        
        if (xWins && turn == 0 || oWins && turn == 1)
            return false;
        
        return (turn == 0 || turn == 1) && (!xWins || !oWins);
        
        
        
    }
}