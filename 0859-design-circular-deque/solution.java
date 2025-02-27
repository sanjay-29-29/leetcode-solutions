class MyCircularDeque {
    private class Node {
        Node prev, next;
        int val;

        Node(Node _prev, Node _next, int _val) {
            prev = _prev;
            next = _next;
            val = _val;
        }
    }

    int size, currSize;
    Node head, tail;

    public MyCircularDeque(int k) {
        this.currSize = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        size++;
        Node newNode = new Node(null, head, value);

        if (head == null) {
            head = tail = newNode;
            return true;
        }

        head.prev = newNode;
        head = newNode;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        size++;
        Node newNode = new Node(tail, null, value);

        if (tail == null) {
            head = tail = newNode;
            return true;
        }

        tail.next = newNode;
        tail = newNode;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        size--;

        head = head.next;

        if (head == null) {
            tail = null;
            return true;
        }
        
        head.prev = null;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        size--;
        tail = tail.prev;

        if (tail == null) {
            head = null;
            return true;
        }

        tail.next = null;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size == currSize) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
