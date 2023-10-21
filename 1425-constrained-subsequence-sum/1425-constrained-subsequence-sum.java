class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        //maintain window of k
        Deque<Integer> queue = new ArrayDeque<>();
        //dp[i] will store max sum subnseq till ith using k diff condition
        int dp[] = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() > k) {
                queue.poll();
            }
            //q front will have max sum of subseqs with k diff index
            dp[i] = (!queue.isEmpty() ? dp[queue.peekFirst()] : 0) + nums[i];
            //maintain only new larger sum index in the q
            while (!queue.isEmpty() && dp[queue.peekLast()] < dp[i]) {
                queue.pollLast();
            }
            
            if (dp[i] > 0) {
                queue.offer(i);
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }
        
        return ans;
    }
}