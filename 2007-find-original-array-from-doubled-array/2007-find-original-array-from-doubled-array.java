class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        if (n % 2 != 0) return new int[0];
        
        int[] result = new int[n / 2];
        
        TreeMap<Integer, Integer> count = new TreeMap<>();
        
        int index = 0;
        
        for (int i : changed)
            count.put(i, count.getOrDefault(i, 0) + 1);
        
        for (int x : count.keySet()) {
            if (count.get(x) > count.getOrDefault(x * 2, 0))
                return new int[0];
            
            for (int i = 0; i < count.get(x); i++) {
                result[index++] = x;
                
                count.put(x * 2, count.get(x * 2) - 1);
            }
        }
        
        return result;
    }
}