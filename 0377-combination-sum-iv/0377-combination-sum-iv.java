class Solution {
    Integer[][] dp;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new Integer[nums.length][target + 1];
        return dfs(nums, 0, target);
    }
    public int dfs(int[] nums, int i, int t) {
        if(t == 0) return 1;
        else if (i == nums.length) return 0;
        else if(dp[i][t] != null) return dp[i][t];
        int count = 0;
        for(int k = 0; k < nums.length; k++) {
            if(t - nums[k] >= 0) {
                count += dfs(nums, k, t - nums[k]);
            } else break;
        }
        return dp[i][t] = count;
    }
}
/*
4
1 2 3

4. 3. 2. 1 
1, 1, 1, 1
1, 1, 


*/