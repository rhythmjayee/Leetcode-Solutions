class Solution {
     public int minimumOperations(List<Integer> A) {
        int n = A.size(), dp[] = new int[]{n, n, n, n};
        //dp[k] means the number of operation we need to make A increasing from 1 to k.
        for (int a : A) {
            dp[a]--;
            dp[2] = Math.min(dp[2], dp[1]);
            dp[3] = Math.min(dp[3], dp[2]);
        }
        return dp[3];
    }
}