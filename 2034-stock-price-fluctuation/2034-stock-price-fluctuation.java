class StockPrice {

    private TreeMap<Integer, Integer> record;
    private TreeMap<Integer, Set<Integer>> values;
    
    
    public StockPrice() {
        record = new TreeMap<>();
        values = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int previousPrice = record.get(timestamp);
            
            Set<Integer> value = values.get(previousPrice);
            value.remove(timestamp);
            if (value.isEmpty()) {
                values.remove(previousPrice);
            }
        }
        
        values.putIfAbsent(price, new HashSet<>());
        values.get(price).add(timestamp);
        record.put(timestamp, price);
    }
    
    public int current() {
        return record.lastEntry().getValue();
    }
    
    public int maximum() {
        return values.lastKey();
    }
    
    public int minimum() {
        return values.firstKey();
    }
}

/*


1=3, 2=5, 4=2, 6=10
10=1,6
5=2
4=2
min=(4, 2)
max=(1, 10)
cur=(4, 2)
*/

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */