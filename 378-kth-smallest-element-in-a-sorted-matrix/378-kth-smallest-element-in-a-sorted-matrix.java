class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        Set<Integer> unique = new HashSet<>();
        
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                pq.add(matrix[r][c]);
                
                if (pq.size() > k)
                    pq.poll();
            }
        }
        
        return pq.peek();
    }
}