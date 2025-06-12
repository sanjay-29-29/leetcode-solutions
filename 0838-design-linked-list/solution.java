class MyLinkedList {
 
    class Node {
        int val;
        Node next;

        Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head; 
    int size;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        Node curr = head;
        for(int i = 0; curr != null; i++) {
            if(i == index) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val, head);
        size++;
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) { 
        Node newNode = new Node(val, null);
        size++;
        if(head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        if(index <= 0) {
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }

        Node curr = head, prev = null;
        Node newNode = new Node(val, null);
        size++;

        for(int i = 0; curr != null; i++) {
            if(i == index) {
                prev.next = newNode;
                newNode.next = curr;          
                return; 
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) {
            return;
        }

        size--; 

        if(index == 0) {
            if(head != null)
                head = head.next;    
            return;
        }

        Node curr = head, prev = null;

        for(int i = 0; curr != null; i++) {
            if(i == index) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
