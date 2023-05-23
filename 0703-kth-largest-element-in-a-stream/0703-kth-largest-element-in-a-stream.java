class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for(int i = 0 ; i<nums.length; i++) {
            adjustKthLargetStream(nums[i]);
        }
    }
    
    public int add(int val) {
        adjustKthLargetStream(val);
        return pq.peek();
    }
    private void adjustKthLargetStream(int val) {
        if(pq.size() < k) {
            pq.add(val);
        } else {
            int t = pq.peek();
            if(t <= val) {
                pq.remove();
                pq.add(val);
            }
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */