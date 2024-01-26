class Solution {
    private Integer[][][] dp;
    private final static int MOD = (int)(1e9 + 7);
    private final static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        return dfs(startRow, startColumn, m, n, maxMove);
    }
    public int dfs(int i, int j, int m, int n, int moveLeft) {
        if((i < 0 || i == m || j < 0 || j == n) && moveLeft >= 0) return 1;
        else if(moveLeft < 0) return 0;
        else if(dp[i][j][moveLeft] != null) return dp[i][j][moveLeft];
        
        int sum = 0;
        for(int[] x : dirs) {
            int rs = dfs(i + x[0], j + x[1], m, n, moveLeft - 1);
            sum = (sum + rs) % MOD;
        }
        return dp[i][j][moveLeft] = sum;
    }
}