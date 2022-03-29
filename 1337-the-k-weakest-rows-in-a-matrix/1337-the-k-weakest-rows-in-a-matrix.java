class Solution {
    
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        
        for (int i = 0; i < mat.length; i++) {
            int strength = search(mat[i]);
            
            int[] entry = new int[] {strength, i};
            
            pq.add(entry);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        
        for (int i = k - 1; i >= 0; i--) {
            int[] pair = pq.poll();
            result[i] = pair[1];
        }
        
        return result;
    }
    
    public int[] kWeakestRows_hashmap(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        
        for (int i = 0; i < mat.length; i++) {
            int strength = search(mat[i]);
            
            if (!freq.containsKey(strength)) {
                freq.put(strength, new ArrayList<>());
            }
            
            freq.get(strength).add(i);
        }
        
        List<Integer> sortedStrengths = new ArrayList<>(freq.keySet());
        Collections.sort(sortedStrengths);
        
        int[] result = new int[k];
        int i = 0;
        
        for (int key : sortedStrengths) {
            for (int index : freq.get(key)) {
                result[i] = index;
                i++;
                
                if (i == k) break;
            }
            
            if (i == k) break;
        }
        
        return result;
    }
    
    public int[] kWeakestRows_old(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < mat.length; i++) {
            if (pq.size() > 3) pq.poll();
            
            pq.offer(search(mat[i]) + 1);
            System.out.println(pq);
        }
        
        int[] result = new int[k];
        
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }
        
        return result;
    }
    
    public int search(int[] arr) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}