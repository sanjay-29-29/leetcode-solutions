class DLL {
    DLL next;
    DLL prev;
    int key;
    int val;

    DLL(DLL _prev, DLL _next, int _key, int _val) {
        next = _next;
        prev = _prev;
        val = _val;
        key = _key;
    }
}

class LRUCache {
    int capacity, currCapacity;
    DLL head, tail;

    Map<Integer, DLL> map = new HashMap<>();

    public LRUCache(int _capacity) {
        capacity = _capacity;
    }

    public int get(int key) {
        //traverse();
        DLL dll = map.get(key);
        if (dll == null) {
            return -1;
        }
        if (dll == head) {
            return dll.val;
        }
        removeNode(dll);
        makeHead(dll);
        return dll.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLL dll = map.get(key);
            dll.val = value;
            if (dll != head) {
                removeNode(dll);
                makeHead(dll);
            }
            return;
        }

        if (head == null && tail == null) {
            head = tail = new DLL(null, null, key, value);
            map.put(key, head);
            currCapacity++;
            return;
        }

        if (currCapacity == capacity) {
            DLL dll = new DLL(null, null, key, value);
            map.remove(tail.key);
            removeNode(tail);
            map.put(key, dll);
            makeHead(dll);
            return;
        }

        currCapacity++;
        DLL dll = new DLL(null, null, key, value);
        map.put(key, dll);
        makeHead(dll);
        return;
    }

    private void removeNode(DLL node) {
        if(node == head){
            head = head.next;
        }
        if(node == tail){
            tail = tail.prev;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
    }

    private void makeHead(DLL node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void traverse() {
        DLL temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("END");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
