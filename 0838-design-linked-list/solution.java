class Node{
    Node prev;
    Node next;
    int val;

    Node(Node _left, Node _right, int _val){
        prev = _left;
        next = _right;
        val = _val;
    }
}

class MyLinkedList {
    Node head, tail;
    int size;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(head == null){
            return -1;
        }

        if(index < 0 || index >= size){
            return -1;
        }

        int i = 0;
        Node node = head;

        while(node != null){
            if(i == index){
                return node.val;
            }
            node = node.next;
            i++;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        size++;
        if(head == null && tail == null){
            head = tail = new Node(null, null, val);
            return;
        }

        Node temp = new Node(null, head, val);
        head.prev = temp;
        head = temp;
    }
    
    public void addAtTail(int val) {
        size++;
        if(head == null && tail == null){
            head = tail = new Node(null, null, val);
            return;
        }
        Node temp = new Node(tail, null, val);
        tail.next = temp;
        tail = temp;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
           return; 
        }

        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }

        size++;
        int i = 0;
        Node prev = null, curr = head;

        while(curr != null){
            if(i == index){
                Node newNode = new Node(prev, curr, val);
                prev.next = newNode;
                curr.prev = newNode;
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }

    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
        //    System.out.println(index);
           return; 
        }

        if(index == 0){
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
            return;
        }

        if(index == size - 1){
            tail = tail.prev;
            if(tail == null){
                head = null;
            }
            size--;
            return;
        }

        int i = 0;
        Node prev = null, curr = head;

        while(curr != null){
            if(index == i){
                prev.next = curr.next;
                break;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        size--;
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
