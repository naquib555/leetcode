class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        
        
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b)->frequency.get(a)-frequency.get(b));
        
        for(int num : nums) {
            int count = frequency.containsKey(num) ? frequency.get(num) : 0;
            frequency.put(num, ++count);
        }
        
        
        for(int num : frequency.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        int[] result = new int[k];
        
        int i=k;
        while(!minHeap.isEmpty())
            result[--k] = minHeap.poll();
        
        return result;
    }
}