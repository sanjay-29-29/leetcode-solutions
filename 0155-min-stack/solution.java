class MinStack {
    class Element{
        int min, ele;

        Element(int _min, int _ele){
            min = _min;
            ele = _ele;
        }
    }

    Stack<Element> stack = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        if(stack.isEmpty()){ 
            stack.push(new Element(val, val));
            return;
        }
        int min = stack.peek().min;
        min = Math.min(min, val);
        stack.push(new Element(min, val));
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
       return stack.peek().ele; 
    }
    
    public int getMin() {
        return stack.peek().min;
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
