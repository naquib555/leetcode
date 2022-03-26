class Solution {
    public int[][] merge(int[][] intervals) {
/*
start = 1 2 8 15
end = 3 6 10 18

start = 1 4
end = 4 5

startMin = INF 1 
endMax = -INF 6

*/
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int startMin = intervals[0][0];
        int endMax = intervals[0][1];
        
        List<int[]> result = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= endMax) {
                endMax = Math.max(endMax, intervals[i][1]);
            } else if (intervals[i][0] > endMax) {
                endMax = Math.max(endMax, intervals[i - 1][1]);
                result.add(new int[] {startMin, endMax});
                startMin = intervals[i][0];
                endMax = intervals[i][1];
            }
        }
        
        result.add(new int[] {startMin, endMax});
        
        int [][] finalResult = new int[result.size()][2];
        
        int count = 0;
        for (int[] r : result) {
            finalResult[count++] = r;
        }
        
        return finalResult;
    }
}

