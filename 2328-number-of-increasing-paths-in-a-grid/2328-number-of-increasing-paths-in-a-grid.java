class Solution {
    public static int mod = (int)(1e9+7);
    public static int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean negativeCondition(int[][] g, int i, int j, int prev) {
        if(i < 0 || j < 0 || i == g.length || j == g[0].length || prev >= g[i][j])
            return true;
        return false;
    }
    public int countPaths(int[][] g) {
        long[][] dp = new long[g.length][g[0].length];
        long count = 0;
        for(int i = 0; i<g.length; i++) {
            for(int j = 0; j<g[0].length; j++) {
                long res = dfs(g, i, j, dp);
                count = (count + res + 1)%mod;
            }
        }
        return (int)count;
        
    }
    public long dfs(int[][] g, int i, int j, long[][] dp) {
        if(dp[i][j] != 0) return dp[i][j];
        int cur = g[i][j];
        // System.out.println(cur);
        long count = dp[i][j];
        for(int k = 0; k<4; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if(!negativeCondition(g, x, y, cur)) {
                count += (1L + dfs(g, x, y, dp))%mod;
            }
        }
        dp[i][j] = count;
        return count;
    }
}