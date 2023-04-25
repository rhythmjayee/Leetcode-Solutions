class SmallestInfiniteSet {
    int counter;
    int small;
    PriorityQueue<Integer> added;
    Set<Integer> set;
    public SmallestInfiniteSet() {
        counter = 1;
        small = 1;
        added = new PriorityQueue<>(); 
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        int ans = -1;
        if(counter == small) {
            ans = small;
            counter++;
            small++;
            return ans;
        }
        
        ans = added.poll();
        set.remove(ans);
        if(added.size() > 0)
            small = added.peek();
        else small = counter;
        
        return ans;
    }
    
    public void addBack(int num) {
        if(set.contains(num) || num >= counter) return;
        small = Math.min(small, num);
        added.add(num);
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */