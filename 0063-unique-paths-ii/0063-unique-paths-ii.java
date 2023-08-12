class Solution {
    public int uniquePathsWithObstacles(int[][] gd) {
        int n = gd.length;
        int m = gd[0].length;
        int[][] dp = new int[n][m];
        
        boolean rock = false;
        for(int i = 0; i<m; i++) {
            if(gd[0][i] == 1) rock = true;
            dp[0][i] = rock ? 0 : 1;
        }
        rock = false;
        for(int i = 0; i<n; i++) {
            if(gd[i][0] == 1) rock = true;
            dp[i][0] = rock ? 0 : 1;
        }
        
        for(int i = 1; i<n; i++) {
            for(int j = 1; j < m; j++) {
                if(gd[i][j] == 0) {
                    dp[i][j] += (dp[i - 1][j] + dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}