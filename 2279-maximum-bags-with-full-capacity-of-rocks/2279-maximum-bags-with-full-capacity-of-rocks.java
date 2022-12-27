class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        for(int i = 0; i<rocks.length; i++) {
            pq.add(capacity[i] - rocks[i]);
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int r = pq.poll();
            if(r <= additionalRocks) {
                additionalRocks -= r; 
                count++;
            }else break;
        }
        return count;
    }
}