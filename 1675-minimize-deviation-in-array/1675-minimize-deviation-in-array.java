class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int a : nums)  {
            if (a % 2 == 1) {
                a = a * 2;
            }
            pq.offer(a);
            min = Math.min(min, a);
        }
        while (pq.peek() % 2 == 0) {
            res = Math.min(res, pq.peek() - min);
            min = Math.min(min, pq.peek() / 2);
            pq.offer(pq.peek() / 2);
            pq.poll();
        }
        return Math.min(res, pq.peek() - min);
        
    }
}