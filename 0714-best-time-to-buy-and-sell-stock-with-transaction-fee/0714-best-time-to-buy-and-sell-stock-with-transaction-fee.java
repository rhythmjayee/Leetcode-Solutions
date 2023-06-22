class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];//buy -> total money on buy call till ith
        dp[0][1] = 0;//sell -> total money on sell call till ith
        
        for(int i = 1; i<n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - fee + prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        }
        return dp[n - 1][1];
    }
}