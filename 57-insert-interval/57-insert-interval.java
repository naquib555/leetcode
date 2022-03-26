class Solution {
    LinkedList<int[]> result;
    
    void addIntoResult(int[] interval) {
        if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = 
                    Math.max(result.getLast()[1], interval[1]);
            }
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        result = new LinkedList<>();
        
        int i = 0;
        
        while (i < intervals.length && newInterval[0] > intervals[i][0]) {
            addIntoResult(intervals[i]);
            i++;
        }
        
        addIntoResult(newInterval);
        
        while (i < intervals.length) {
            addIntoResult(intervals[i]);
            i++;
        }
                                           
        int[][] finalResult = new int[result.size()][2];
        int count = 0;
        for (int[] r : result) {
            finalResult[count++] = r;
        }
        return finalResult;
    }
    
    public int[][] insert_old(int[][] intervals, int[] newInterval) {
        
        if (intervals.length == 0) return new int[][]{newInterval};
        LinkedList<int[]> result = new LinkedList<>();
        
        int lastIndex = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0])
                lastIndex = i;
            else break;
        }
        
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            if (i == lastIndex) {
                end = Math.max(end, newInterval[1]);
            }
            if (result.isEmpty() || result.getLast()[1] < intervals[i][0]) {
                result.add(new int[]{intervals[i][0], end});
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], end);
            }
        }
        
        int[][] finalResult = new int[result.size()][2];
        int count = 0;
        for (int[] r : result) {
            finalResult[count++] = r;
        }
        return finalResult;
    }
}