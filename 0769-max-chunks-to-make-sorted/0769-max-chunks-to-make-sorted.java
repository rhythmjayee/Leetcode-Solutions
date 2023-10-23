class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> sk = new LinkedList<>();
        for(int x : arr) {
            int max = x;
            while(!sk.isEmpty() && sk.getLast() > x) {
                max = Math.max(max, sk.removeLast());
            }
            sk.addLast(max);
        }
        return sk.size();
    }
}