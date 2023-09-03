class Solution {
    public int uniquePaths(int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i<n; i++) {
            for(int j = 1; j < m; j++) {
                //dp[j] will be holding the jth ans for i-1th row
                dp[j] += dp[j - 1]; 
            }
        }
        return dp[m - 1];
    }
}