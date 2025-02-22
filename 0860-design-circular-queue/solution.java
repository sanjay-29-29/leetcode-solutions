class MyCircularQueue {
    int[] queue;
    int front = -1;
    int rear = -1;

    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (rear == -1 && front == -1) {
            rear = front = 0;
        } else {
            rear++;
        }
        queue[rear % queue.length] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front % queue.length];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear % queue.length];
    }

    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (queue.length == 1) {
            if (front == 0 && rear == 0) {
                return true;
            }
            return false;
        }
        if ((rear + 1) % queue.length == front % queue.length) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
