class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i<=n; i++) {
            dp[i] = dp[i >> 1];
            if((i & 1) != 0) dp[i]++;
        }
        return dp;
    }
}

/*
i = 4
00100
i >> 1
00010 = 2
i = 5
00101
i >> 1 = 2
00010
*/