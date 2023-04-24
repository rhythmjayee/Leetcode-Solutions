class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);
        for(int x : stones){
            max.add(x);
        }
        while(max.size() > 1){
            int a = max.poll();
            int b = max.poll();
            int diff = a-b;
            if(diff > 0) max.add(diff);
        }
        return max.size() == 0 ? 0 : max.peek();
    }
}