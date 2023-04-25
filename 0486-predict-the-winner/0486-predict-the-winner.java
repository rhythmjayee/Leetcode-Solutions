class Solution {
    Integer[][] dp;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        dp = new Integer[n][n];
        int ans = top(nums, 0, n - 1);
        // System.out.println(sum+" "+ans);
        return sum - ans <= ans; 
    }
    public int top(int[] nums, int i, int j) {
        if(i == j) return nums[i];
        else if(j - i == 1) return Math.max(nums[i], nums[j]);
        else if(dp[i][j] != null) return dp[i][j];
        
        int f = nums[i] + Math.min(top(nums, i + 2,  j), top(nums, i + 1, j - 1));
        int r = nums[j] +  Math.min(top(nums, i + 1,  j - 1), top(nums, i, j - 2));

        return dp[i][j] = Math.max(f, r);
    }
}