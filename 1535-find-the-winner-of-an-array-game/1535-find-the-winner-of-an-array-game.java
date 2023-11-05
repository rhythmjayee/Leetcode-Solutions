class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        for(int x : arr) {
            dq.addLast(x);
        }
        int count = 0;
        int prev = 0;
        int total = 0;
        int maxOfAll = 0;
        while(total < 2 * n) {
            if(count == k) break;
            int a = dq.removeFirst();
            int b = dq.removeFirst();
            int max = Math.max(a, b);
            maxOfAll = Math.max(maxOfAll, max);
            int min = Math.min(a, b);
            if(prev != max) {
                count = 1;
                prev = max;
            } else {
                count++;
            }
            dq.addFirst(max);
            dq.addLast(min);
            total++;
        }
        return total == 2*n ? maxOfAll : prev;
    }
}