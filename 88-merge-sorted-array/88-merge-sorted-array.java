class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a,b));
        
        for (int num : nums2)
            pq.add(num);
        
        int i = 0;
        while (i < m) {
            if (!pq.isEmpty() && nums1[i] > pq.peek()) {
                int tempValue = nums1[i];
                nums1[i] = pq.poll();
                pq.add(tempValue);
            }
            i++;
        }
        
        while (!pq.isEmpty()) {
            nums1[i++] = pq.poll();
        }
        
    }
    
    /*
    nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    
    
    */
}