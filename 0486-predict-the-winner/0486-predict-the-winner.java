class Solution {
    Integer[][] dp;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        //total score
        int sum = 0;
        for(int x : nums) sum += x;
        
        dp = new Integer[n][n];
        int ans = top(nums, 0, n - 1);
        //score of p2 should be <= p1
        return sum - ans <= ans; 
    }
    public int top(int[] nums, int i, int j) {
        if(i == j) return nums[i];
        else if(j - i == 1) return Math.max(nums[i], nums[j]);
        else if(dp[i][j] != null) return dp[i][j];
        /*  
            p1 take ith , p2 will choose next 
            if p2 can choose i+1th or jth -> out these p1 should get min remaining vals 
        */
        int f = nums[i] + Math.min(top(nums, i + 2,  j), top(nums, i + 1, j - 1));
        /*  
            p1 take jth , p2 will choose next 
            if p2 can choose ith or j - 1th -> out these p1 should get min remaining vals 
        */
        int r = nums[j] +  Math.min(top(nums, i + 1,  j - 1), top(nums, i, j - 2));

        return dp[i][j] = Math.max(f, r);
    }
}