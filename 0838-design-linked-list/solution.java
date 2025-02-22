class Node {
    Node prev;
    Node next;

    int val;

    Node(Node _prev, Node _next, int _val) {
        prev = _prev;
        next = _next;
        val = _val;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size = 0;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }

        int i = 0;
        Node temp = head;

        while (temp != null) {
            if (i == index) {
                return temp.val;
            }
            i++;
            temp = temp.next;
        }

        return -1;
    }

    public void addAtHead(int val) {
        size++;
        Node node = new Node(null, null, val);
        if (head == null && tail == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addAtTail(int val) {
        size++;
        Node node = new Node(null, null, val);
        if (head == null && tail == null) {
            head = tail = node;
            return;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        int i = 0;
        Node node = new Node(null, null, val);
        Node temp = head;
        size++;

        while (temp != null) {
            if (i == index) {
                node.prev = temp.prev;
                node.next = temp;
                temp.prev.next = node;
                temp.prev = node;
                break;
            }
            i++;
            temp = temp.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || head == null) {
            return;
        }

        if (index == 0) {
            size--;
            head = head.next;
            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }
            return;
        }


        if (index == size - 1) {
            size--;
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }else{
                head = null;
            }
            return;
        }

        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (i == index) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                break;
            }
            i++;
            temp = temp.next;
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
