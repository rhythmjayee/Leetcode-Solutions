class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for(int x : piles){
            sum += x;
            pq.add(x);
        }
        
        while(!pq.isEmpty() && k-- > 0) {
            int x = pq.remove();
            int y = x % 2 == 0 ? x/2 : x/2 + 1;
            sum -= (x - y);
            pq.add(y);
        }
        return sum;
    }
}