class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n + 1];
        return dfs(n);
    }
    public int dfs(int n) {
        if(n == 2) return 1;
        else if(dp[n] != 0) return dp[n];
        
        int max = 0;
        for(int k = 1; k <= n - 1; k++) {
            int res = dfs(n - k);
            max = Math.max(max, Math.max(k * (n - k),k * res));
        }
        return dp[n] = max;
    }
}