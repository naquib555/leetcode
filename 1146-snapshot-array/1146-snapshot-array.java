class SnapshotArray {

    TreeMap<Integer, Integer> [] array;
    int snap_id;
    
    public SnapshotArray(int length) {
        this.array = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            this.array[i] = new TreeMap<Integer, Integer>();
            this.array[i].put(0, 0);
        }
        this.snap_id = 0;
    }
    
    public void set(int index, int val) {
        this.array[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        return array[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */