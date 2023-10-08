class Solution {
    Integer[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        dp = new Integer[n][m];
        int ans = dfs(0, 0, nums1, nums2);
        return ans;
    }
    public int dfs(int i, int j, int[] n1, int[] n2) {
        if(i == n1.length || j == n2.length) return Integer.MIN_VALUE;
        else if(dp[i][j] != null) return dp[i][j];
        
        int max = Integer.MIN_VALUE;
        int r1 = dfs(i + 1, j + 1, n1, n2);
        int r2 = (n1[i] * n2[j]);
        int a1 = r2+ (r1 == Integer.MIN_VALUE ? 0 : r1);
        int a2 = r1;
        int a3 = r2;
        int b = dfs(i + 1, j, n1, n2);
        int c = dfs(i, j + 1, n1, n2);
        max = Math.max(a3, Math.max(Math.max(a1, a2), Math.max(b, c)));
        return dp[i][j] = max;
    }
}