class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int s : stones)
            pq.add(s);
        
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            
            if (stone1 != stone2)
                pq.add(stone1 - stone2);
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}