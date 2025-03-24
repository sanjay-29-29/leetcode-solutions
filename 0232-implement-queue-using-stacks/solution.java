class MyQueue {
    Stack<Integer> queue1 = new Stack<>();
    Stack<Integer> queue2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        int res = 0;
        
        while (!queue1.isEmpty()) {
            int val = queue1.pop();
            if (queue1.size() == 0) {
                res = val;
                break;
            }
            queue2.push(val);
        }

        while (!queue2.isEmpty()) {
            queue1.push(queue2.pop());
        }

        return res;
    }

    public int peek() {
        int res = 0;

        while (!queue1.isEmpty()) {
            int val = queue1.pop();
            if (queue1.size() == 0) {
                res = val;
            }
            queue2.push(val);
        }

        while (!queue2.isEmpty()) {
            queue1.push(queue2.pop());
        }

        return res;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
