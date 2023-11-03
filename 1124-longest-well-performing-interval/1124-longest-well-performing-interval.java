class Solution {
    public int longestWPI(int[] hours) {
        int len = hours.length;
        int[] preSum = new int[len+1];   // prefix Sum
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i-1] + (hours[i-1] > 8 ? 1 : -1);
        }
        Deque<Integer> stack = new LinkedList<>();   // Deque (8ms) is much faster than Stack (18ms)
        for (int i = 0; i <= len; i++) {
            if (stack.isEmpty() || preSum[stack.getLast()] > preSum[i]) {
                stack.addLast(i);
            }
        }
        int res = 0;
        for (int j = len; j >= 0; j--) {  // start from end
            while (!stack.isEmpty() && preSum[stack.getLast()] < preSum[j]) {
                res = Math.max(res, j-stack.removeLast());
            }
        }
        return res;
    }
}