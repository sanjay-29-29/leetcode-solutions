class LRUCache {
    class Node {
        int key, val;
        Node next, prev;

        Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    int maxCapacity, size;
    Node head = null, tail = null; 

    public LRUCache(int capacity) {
       maxCapacity = capacity; 
    }
    
    public int get(int key) {
        Node n = map.get(key);    
        if(n == null) {
            return -1;
        }
        makeHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        //key already exists
        Node n = map.get(key);
        if(n != null) {
            n.val = value;
            makeHead(n);
            return;
        }

        if(size == maxCapacity) {
            removeLast();
            size--;
        }
        
        n = new Node(key, value, null, null);
        map.put(key, n);
        makeHead(n);
        size++;
    }

    public void makeHead(Node n) {
        if(n == null || head == n) {
            return;
        }
        if(head == null || tail == null) {
            head = tail = n;
            return;
        }
        if(n == tail) {
            tail = tail.prev;
        }
        if(n.next != null) {
            n.next.prev = n.prev;
        }
        if(n.prev != null) {
            n.prev.next = n.next;
        }
        n.prev = null;
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void removeLast() {
        if(head == null || tail == null) {
            return;
        }

        map.remove(tail.key);
        // System.out.println(tail.val); 
        tail = tail.prev;

        if(tail == null) {
            head = null;
            return;
        }

        tail.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
