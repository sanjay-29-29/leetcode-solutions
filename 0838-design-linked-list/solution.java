class MyLinkedList {
    class ListNode {
        ListNode prev, next;
        int val;

        ListNode(ListNode prev, ListNode next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    int size = 0;
    ListNode head = null, tail = null;

    public MyLinkedList() {
    }

    public int get(int index) {
        int i = 0;
        ListNode temp = head;

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
        ListNode node = new ListNode(null, head, val);
        if (head == null) {
            head = tail = node;
            return;
        }
        head.prev = node;
        head = node;
    }

    public void addAtTail(int val) {
        size++;
        ListNode node = new ListNode(tail, null, val);
        if (tail == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode curr = head;
        int i = 0;

        while (curr != null) {
            if (index == i) {
                size++;
                ListNode node = new ListNode(curr.prev, curr, val);
                if (curr.prev != null) {
                    curr.prev.next = node;
                }
                curr.prev = node;
                return;
            }
            curr = curr.next;
            i++;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            if (head == null) {
                head = tail = null;
                return;
            }
            head.prev = null;
            return;
        }

        if (index == size - 1) {
            tail = tail.prev;
            size--;
            if (tail == null) {
                tail = head = null;
                return;
            }
            tail.next = null;
            return;
        }

        ListNode curr = head;
        int i = 0;

        while (curr != null) {
            if (i == index) {
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                }
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                size--;
                return;
            }
            i++;
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
