class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap<>();
        
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                PriorityQueue<Integer> pq = diagonalMap.getOrDefault(r - c, new PriorityQueue<>());
                pq.add(mat[r][c]);
                diagonalMap.put(r - c, pq);
            }
        }
        
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                PriorityQueue<Integer> pq = diagonalMap.get(r - c);
                mat[r][c] = pq.poll();
            }
        }
        return mat;
    }
}