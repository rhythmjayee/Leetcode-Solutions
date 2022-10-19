class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String s : words) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(freq.get(a) == freq.get(b)) return a.compareTo(b);
            return freq.get(b) - freq.get(a);
        });
        
        for(String s : freq.keySet()) {
            pq.add(s);
        }
        
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty() && ans.size() < k) {
            ans.add(pq.remove());
        }
        
        return ans;
    }
}