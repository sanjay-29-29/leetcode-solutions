class Node {
    int val;
    Node next;

    Node(int _val, Node _next){
        val = _val;
        next = _next;
    }
}

class MyHashSet {
    Node[] set = new Node[10];

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int index = key % 10;

        if(set[index] == null) {
            set[index] = new Node(key, null);
            return;
        } 

        Node temp = set[index];

        while(temp != null){
            if(temp.val == key){
                return;
            }
            temp = temp.next;
        }

        Node newNode = new Node(key, set[index]);
        set[index] = newNode;
    }
    
    public void remove(int key) {
        int index = key % 10;

        if(set[index] == null){
            return;
        }

        if(set[index].val == key){
            set[index] = set[index].next;
            return;
        }

        Node prev = null, curr = set[index];

        while(curr != null){
            if(curr.val == key){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index = key % 10;
        Node curr = set[index];

        while(curr != null){
            if(curr.val == key){
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
