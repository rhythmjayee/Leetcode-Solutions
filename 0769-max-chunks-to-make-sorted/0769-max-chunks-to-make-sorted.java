class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> sk = new LinkedList<>();
        for(int x : arr) {
            if(!sk.isEmpty() && sk.getLast() > x) {
                int max = 0;
                while(!sk.isEmpty() && sk.getLast() > x) {
                    max = Math.max(max, sk.removeLast());
                }
                sk.addLast(max);
            } else {
                sk.addLast(x);
            }
        }
        return sk.size();
    }
}