class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        
        int nRows = cols;
        int nCols = rows;
        
        char[][] rotatedBox = new char[nRows][nCols];
        
        for (int r = rows - 1; r >= 0; r--) {
            int spaceCount = 0;
            for (int c = cols - 1; c >= 0; c--) {
                int nr = c;
                int nc = nCols - 1 - r;
                
                if (box[r][c] == '.') {
                    spaceCount++;
                    rotatedBox[nr][nc] = box[r][c];
                } else if (box[r][c] == '*') {
                    spaceCount = 0;
                    rotatedBox[nr][nc] = box[r][c];
                } else {
                    rotatedBox[nr][nc] = rotatedBox[nr + spaceCount][nc];
                    rotatedBox[nr + spaceCount][nc] = '#';
                }
            }
        }
        return rotatedBox;
    }
}