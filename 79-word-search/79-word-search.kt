class Solution {
    
    val rowDir: IntArray = intArrayOf(0, 1, 0, -1)
    val colDir: IntArray = intArrayOf(1, 0, -1, 0)
    
    var rows: Int = 0
    var cols: Int = 0
    
    lateinit var board: Array<CharArray>
    
    fun exist(board: Array<CharArray>, word: String): Boolean {
        
        this.board = board
        
        rows = board.size
        cols = board[0].size
        
        for (i in 0..rows-1) {
            for (j in 0..cols-1) {
                if (backtrack(i, j, word, 0))
                    return true
            }
        }
        
        return false
    }
    
    fun backtrack(i: Int, j: Int, word: String, index: Int): Boolean {
        if (index >= word.length)
            return true
        
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word[index])
            return false
        
        board[i][j] = '#'
        
        for (d in 0..3)
            if (backtrack(i + rowDir[d], j + colDir[d], word, index + 1))
                return true
        
        board[i][j] = word[index]
        
        return false
    }
}