class MyHashSet {

    private int totalKeySpace;
    private List<Bucket> bucket;
    
    public MyHashSet() {
        this.totalKeySpace = 2069;
        this.bucket = new ArrayList<>();
        
        for (int i = 0; i < this.totalKeySpace; i++) {
            this.bucket.add(new Bucket());
        }
    }
    
    protected int getHash(int key) {
        return key % this.totalKeySpace;
    }
    
    public void add(int key) {
        int hashKey = getHash(key);
        this.bucket.get(hashKey).insert(key);
    }
    
    public void remove(int key) {
        int hashKey = getHash(key);
        this.bucket.get(hashKey).delete(key);
    }
    
    public boolean contains(int key) {
        int hashKey = getHash(key);
        return this.bucket.get(hashKey).contains(key);
    }
}

class Bucket {
    private LinkedList<Integer> list;
    
    public Bucket() {
        this.list = new LinkedList<Integer>();
    }
    
    public void insert(int key) {
        int index = this.list.indexOf(key);
        if (index == -1) this.list.addFirst(key);
    }
    
    public void delete(int key) {
        int index = this.list.indexOf(key);
        if (index != -1)
            this.list.remove(index);
    }
    
    public boolean contains(int key) {
        int index = this.list.indexOf(key);
        return (index != -1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */