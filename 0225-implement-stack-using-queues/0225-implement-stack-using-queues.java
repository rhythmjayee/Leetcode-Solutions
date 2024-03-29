class MyStack {
    Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        int sz = q.size();
        while(sz-- > 1){
            q.offer(q.poll());
        } 
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        int x = q.peek();

        return x;
    }
    
    public boolean empty() {
        return q.isEmpty();
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