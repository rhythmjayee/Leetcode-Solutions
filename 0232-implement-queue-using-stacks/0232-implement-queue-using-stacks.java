class MyQueue {
    Deque<Integer> sk1;
    Deque<Integer> sk2;
    public MyQueue() {
        sk1 = new LinkedList<>();
        sk2 = new LinkedList<>();
    }
    
    public void push(int x) {
        sk1.addLast(x);
    }
    
    public int pop() {
        if(sk2.size() != 0) return sk2.removeLast();
        transferElements();
        return sk2.removeLast();
    }
    
    public int peek() {
        if(sk2.size() != 0) return sk2.getLast();
        transferElements();
        return sk2.getLast();
    }
    private void transferElements() {
        while(!sk1.isEmpty()) {
            sk2.addLast(sk1.removeLast());
        }
    }
    
    public boolean empty() {
        return sk1.isEmpty() && sk2.isEmpty();
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