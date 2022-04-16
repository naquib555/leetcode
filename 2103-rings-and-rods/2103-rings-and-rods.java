class Solution {
    public int countPoints(String rings) {
        int n = rings.length();
        
        Map<Integer, Set<Character>> rods = new HashMap<>();
        
        int result = 0;
        
        for (int i = 0; i < n; i+=2) {
            Set<Character> color = rods.getOrDefault(rings.charAt(i + 1) - '0', new HashSet<>());
            color.add(rings.charAt(i));
            rods.put(rings.charAt(i + 1) - '0', color);
        }
        
        for (Integer key : rods.keySet()) {
            if (rods.get(key).size() == 3) result++;
        }
        
        return result;
    }
}