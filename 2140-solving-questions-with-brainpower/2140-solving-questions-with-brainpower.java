class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        //only last qu -> can be solved
        dp[n - 1] = questions[n - 1][0];
        
        for (int i = n - 2; i >= 0; --i) {
            dp[i] = questions[i][0];// add val of ith
            int skip = questions[i][1];//get skip val
            if (i + skip + 1 < n) {
                dp[i] += dp[i + skip + 1];//add val of dp just after skip 
            }
            
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        
        return dp[0];
    }
}