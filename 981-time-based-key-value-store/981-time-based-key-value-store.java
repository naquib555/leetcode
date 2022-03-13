class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> records;
    
    public TimeMap() {
        records = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!records.containsKey(key))
            records.put(key, new TreeMap<Integer, String>());
        
        records
            .get(key)
            .put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!records.containsKey(key)) return "";
        TreeMap<Integer, String> info = records.get(key);
        
        Integer floorKey = info.floorKey(timestamp);
        
        return floorKey == null ? "" : info.get(floorKey);
    }
}

/*
HashMap<String, TreeMap<Integer, String>>()
*/

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */