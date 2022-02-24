class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c2.count, c1.count));
        
        if (a != 0) pq.add(new Pair(a, 'a'));
        if (b != 0) pq.add(new Pair(b, 'b'));
        if (c != 0) pq.add(new Pair(c, 'c'));
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            
            if (sb.length() > 1 
                && sb.toString().charAt(sb.length() - 1) == pair.digit 
                && sb.toString().charAt(sb.length() - 2) == pair.digit) {
                
                if (pq.isEmpty()) return sb.toString();
                
                Pair newPair = pq.poll();
                
                sb.append(newPair.digit);
                newPair.count--;
                if (newPair.count != 0) pq.add(newPair);
                
            } else {
                sb.append(pair.digit);
                pair.count--;
            }
            if (pair.count != 0) pq.add(pair);
            
        }
        
        return sb.toString();
        
        
        
    }
    
    /*
    ccaccbcc
    
    a=1
    b=1
    c=7
    
    Heap = 1, 5
    
    ccc
    
    */
}
class Pair {
    public Integer count;
    public Character digit;
    
    public Pair(Integer count, Character digit) {
        this.count = count;
        this.digit = digit;
    }
}