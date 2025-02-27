class MyHashMap {
    Node[] map = new Node[1000];

    class Node {
        int key;
        int val;
        Node next;

        Node(int _key, int _val, Node _next) {
            key = _key;
            val = _val;
            next = _next;
        }
    }

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = key % 1000;
        Node newNode = new Node(key, value, null);
        Node prev = null, node = map[index];
        
        if(map[index] == null){
            map[index] = newNode;
            return;
        }

        while(node != null){
            if(node.key == key){
                node.val = value;
                return;
            }
            prev = node;
            node = node.next;
        }

        prev.next = newNode;
    }

    public int get(int key) {
        int index = key % 1000;
        Node node = map[index];

        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % 1000;
        Node prev = null, node = map[index];


        while (node != null) {
            if (node.key == key) {
                if (prev == null) {
                    map[index] = node.next;
                }else{    
                    prev.next = node.next;
                }
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
