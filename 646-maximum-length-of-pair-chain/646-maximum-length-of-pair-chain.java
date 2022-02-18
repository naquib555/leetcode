class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int dp[] = new int[pairs.length];
        
        int rightValue = Integer.MIN_VALUE;
        int result = 0;
        
        for (int[] pair : pairs) {
            if(rightValue < pair[0]) {
                rightValue = pair[1];
                result++;
            }
        }
        return result;
    }
    
    //[1,2][7,8][4,5]
    //[1,2][4,5][7,8]
    //
    //1 2   3
    //[[1,2],[2,3],[3,4]]
    //
    //1 0   1
    //[[3,6],[1,2],[5,6],[3,5]]
    //[1,2][3,6]
    //[1,2][7,8][4,5]
    
    //[1,2][7,8]
    
    //l = 7
    //if(l<newL)
    //r = 2
    //r>nR
    //count = 1 + 1 
    
}