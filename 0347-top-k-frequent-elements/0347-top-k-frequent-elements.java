class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int idx = 0;
        Map<Integer, Integer> f = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return f.get(a) - f.get(b);
        });
        
        for(int x: nums) {
            f.put(x, f.getOrDefault(x, 0) + 1);
        }
        
        for(int key : f.keySet()) {
            if(pq.size() < k) {
                pq.add(key);
            }else {
                int top = pq.peek();
                int topFreq = f.get(top);
                if(topFreq < f.get(key)) {
                    pq.remove();
                    pq.add(key);
                }
            }
        }
        while(!pq.isEmpty()) ans[idx++] = pq.remove();
        return ans;
    }
}