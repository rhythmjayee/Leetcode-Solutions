class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        
        int[] dp = new int[n];
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++) {
            dp[i] = matrix[n - 1][i];
        }
        
        for(int i = n - 2; i >= 0; i--) {
            int prev = Integer.MAX_VALUE;
            for(int j = 0; j<n; j++) {
                //store the old value of dp[j], for getting left (j - 1) for next iteration
                int tmp = dp[j];
                int l = j - 1 < 0 ? Integer.MAX_VALUE : prev;
                int c = dp[j];
                int r = j + 1 > n - 1 ? Integer.MAX_VALUE : dp[j + 1];
                int minOfThree = Math.min(l, Math.min(c, r));
                dp[j] = minOfThree + matrix[i][j];
                prev = tmp;
            }
        }
        for(int i = 0; i<n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}