class StockSpanner {
    //[price, days]
    private Deque<int[]> sk;
    public StockSpanner() {
        sk = new LinkedList<>();
    }
    
    public int next(int price) {
        if(sk.isEmpty() || sk.getLast()[0] > price) {
            sk.addLast(new int[]{price, 1});
        }else {
            int days = 0;
            while(!sk.isEmpty() && sk.getLast()[0] <= price) {
                days += sk.removeLast()[1];
            }
            sk.addLast(new int[]{price, days + 1});
        }
        
        return sk.getLast()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */