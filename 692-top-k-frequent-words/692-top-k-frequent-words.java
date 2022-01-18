class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> frequency = new HashMap<>();
        List<String> finalResult = new ArrayList<>();
        
        for(String word : words) {
            Integer count = frequency.containsKey(word) ? frequency.get(word) : 0;
            frequency.put(word, ++count);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        
        for(Map.Entry<String, Integer> entry : frequency.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        while(!minHeap.isEmpty()) {
            finalResult.add(0, minHeap.poll().getKey());
        }
        
        return finalResult;
    }
}