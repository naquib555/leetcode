class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n = arr.length;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            if (arr[node] == 0)
                return true;
            
            if (arr[node] > 0) {
                if (node + arr[node] < n)
                    queue.add(node + arr[node]);
                
                if (node - arr[node] >= 0)
                    queue.add(node - arr[node]);
                
                arr[node] *= -1;
            }
        }
        
        return false;
        
    }
}