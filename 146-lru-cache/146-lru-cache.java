class LRUCache {
    
    DLinkedList head;
    DLinkedList tail;
    
    Map<Integer, DLinkedList> map;
    
    int total;
    int index;
    
    public LRUCache(int capacity) {
        total = capacity;
        index = 0;
        
        map = new HashMap<>();
        
        head = new DLinkedList();
        tail = new DLinkedList();
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        DLinkedList node = map.get(key);
        if (node == null) return -1;
        
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        
        DLinkedList node = map.get(key);
        
        if (node == null) {
            node = new DLinkedList();
            
            node.key = key;
            node.value = value;
            
            index++;
            
            add(node);
            
            map.put(key, node);
            
            if (index > total) {
                DLinkedList poppedNode = popTail();
                map.remove(poppedNode.key);
                index--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    public void add(DLinkedList node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    public void remove(DLinkedList node) {
        DLinkedList prev = node.prev;
        DLinkedList next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    public void moveToHead(DLinkedList node) {
        remove(node);
        add(node);
    }
    
    public DLinkedList popTail() {
        DLinkedList node = tail.prev;
        remove(node);
        return node;
    }
}

class DLinkedList {
    public int key;
    public int value;
    public DLinkedList prev;
    public DLinkedList next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */