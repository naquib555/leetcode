class Solution {
    public String reorganizeString(String s) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c2.c, c1.c));
        
        Map<Character, Integer> countMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        countMap.forEach((key, value) -> {
            pq.add(new Pair(value, key));
        });
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            
            if (sb.length() > 0
                && sb.toString().charAt(sb.length() - 1) == pair.d) {
                
                if (pq.isEmpty()) return "";
                
                Pair newPair = pq.poll();
                sb.append(newPair.d);
                newPair.c--;
                if (newPair.c != 0) pq.add(newPair);
            } else {
                sb.append(pair.d);
                pair.c--;
            }
            if (pair.c != 0) pq.add(pair);
        }
        
        return sb.toString();

    }
    
    /*
    aaaaab
    
    Heap = b,1 || a,5
    
    a,a,b,a,a
    
    */
}
class Pair {
    public Integer c;
    public Character d;
    
    Pair (Integer c, Character d) {
        this.c  = c;
        this.d = d;
    }
    
}