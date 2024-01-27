public class Solution {
    public int kInversePairs(int n, int k) {
        /**
        dp[n][k] denotes the number of arrays that have k inverse pairs for array composed of 1 to n
        we can establish the recursive relationship between dp[n][k] and dp[n-1][i]:

        if we put n as the last number then all the k inverse pair should come from the first n-1 numbers
        if we put n as the second last number then there's 1 inverse pair involves n so
        the rest k-1 comes from the first n-1 numbers
        ...
        if we put n as the first number then there's n-1 inverse pairs involve n so
        the rest k-(n-1) comes from the first n-1 numbers

        dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]

        It's possible that some where in the right hand side the second array index become negative, 
        since we cannot generate negative inverse pairs we just treat them as 0,   
        but still leave the item there as a place holder.

        dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
        dp[n][k+1] = dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]

        so by deducting the first line from the second line, we have

        dp[n][k+1] = dp[n][k] + dp[n-1][k+1] - dp[n-1][k+1-n]
        
        */
        int[][] dp = new int[n + 1][k + 1];
        int M = (int)(1e9 + 7);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return ((dp[n][k] + M - (k > 0 ? dp[n][k - 1] : 0)) % M);
    }
}