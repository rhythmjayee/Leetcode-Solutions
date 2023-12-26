class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];


        for (int i = 1; i <= target; i++) {
            dp[1][i] = i <= f ? 1 : 0;
        }

        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++)
                    if (k <= j)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % 1000000007;
            }
        }
        return dp[d][target] % 1000000007;
    }
    /**
    d,f,target
    d == 0 return 0;
    target == 0 return 1;
    for(1 to f)
        d-1,f,target-f
    **/
}