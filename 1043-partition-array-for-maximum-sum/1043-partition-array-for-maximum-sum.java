class Solution {
    Integer[] dp;
    public int dfs(int i, int[] arr, int k) {
        if(i == arr.length) return 0;
        else if(dp[i] != null) return dp[i];
        int max = 0;
        int maxSum = 0;
        
        for(int j = i; j < arr.length && j - i < k; j++) {
            max = Math.max(max, arr[j]);
            int subArraySum = max * (j - i + 1);
            int restSubArraySum = dfs(j + 1, arr, k);
            maxSum = Math.max(subArraySum + restSubArraySum, maxSum);
        }
        return dp[i] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return dfs(0, arr, k);
    }
}