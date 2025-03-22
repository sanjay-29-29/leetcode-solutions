class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        Queue<Integer> newQ = new LinkedList<>();
        int temp = -1;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(queue.size() != 0){
                newQ.add(temp);
            }
        }
        queue = newQ;
        return temp;
    }
    
    public int top() {
        Queue<Integer> newQ = new LinkedList<>();
        int temp = -1;
        while(!queue.isEmpty()){
            temp = queue.poll();
            newQ.add(temp);
        }
        queue = newQ;
        return temp;
    }
    
    public boolean empty() {
       return queue.isEmpty(); 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
