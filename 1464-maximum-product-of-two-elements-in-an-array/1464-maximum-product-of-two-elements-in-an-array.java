class Solution {
    public int maxProduct(int[] nums) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > 2) minHeap.poll();
        }
        System.out.println(minHeap);
        
        return (minHeap.poll()-1) * (minHeap.poll()-1);
        
    }
}