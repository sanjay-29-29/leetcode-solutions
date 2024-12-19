class MinStack {
    class Element {
        int val;
        int prevMin;

        Element(int _val, int _prevMin) {
            val = _val;
            prevMin = _prevMin;
        }
    }

    Stack<Element> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.add(new Element(val, min));
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        Element val = stack.pop();
        if(val.val == min){
            min = val.prevMin;
        }
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
