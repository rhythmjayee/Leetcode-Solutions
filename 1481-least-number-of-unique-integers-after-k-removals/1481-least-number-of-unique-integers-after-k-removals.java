class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        
        for(int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
        for(int x : map.keySet()) pq.add(x);
        System.out.println(pq);
        while(k > 0 && !pq.isEmpty()) {
            int x = pq.remove();
            int freq = map.get(x);
            if(freq > k) return pq.size() + 1;
            
            k -= freq;
        }
        return pq.size();
    }
}