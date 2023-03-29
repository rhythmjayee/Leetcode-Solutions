class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        return top(satisfaction, 0, 0, new Integer[n + 1][n + 1]);
    }
    public int top(int[] sat, int i, int count, Integer[][] dp) {
        if(i == sat.length) return 0;
        else if(dp[i][count + 1] != null) return dp[i][count + 1];
        
        int takeDish = top(sat, i + 1, count + 1, dp) + (count + 1)*sat[i];
        int notTakeDish = top(sat, i + 1, count, dp);
        
        return dp[i][count + 1] = Math.max(takeDish, notTakeDish);
    }
}