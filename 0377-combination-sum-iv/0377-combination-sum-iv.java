class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i<= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                } else break;
            }
        }
        return dp[target];
    }
}
/*
4
1 2 3

4. 3. 2. 1 
1, 1, 1, 1
1, 1, 


*/