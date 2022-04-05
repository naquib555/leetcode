class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {            
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        
        HashSet<Integer> set = new HashSet<>(count.values());
        
        return count.size() == set.size();
    }
}

/*
[3,5,-2,-3,-6,-6]

3 1
5 1
-2 1
-3 1
-6 2
*/