class DetectSquares {

    private HashMap<Pair, Integer> count;
    private HashMap<Integer, ArrayList<Integer>> xList;
    private List<Pair> pList;
    
    public DetectSquares() {
        count = new HashMap<>();
        xList = new HashMap<>();
        pList = new ArrayList<>();
    }
    public void add(int[] point) {
        Pair<Integer, Integer> p = new Pair<>(point[0], point[1]);
        count.put(p, count.getOrDefault(p, 0) + 1);
        pList.add(p);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        
        int result = 0;
        
        for (Pair<Integer, Integer> p : pList) {
            Integer x = p.getKey();
            Integer y = p.getValue();
            
            if (Math.abs(py - y) == Math.abs(px - x) && px != x && py != y) {
                result += count.getOrDefault(new Pair(x, py), 0) * count.getOrDefault(new Pair(px, y), 0);
            }
        }
        
        return result;
    }
    
    
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */