class Solution {
    public int countVowelPermutation(int n) {
        //dp[i][j] stores number of pernumation of len i ending with jth vawel
        long[][] dp = new long[n + 1][5];
        /*
        a = 0, e = 1, i = 2, o = 3, u = 4
        */
        long sum = 0;
        int mod = (int)(1e9+7);
        Arrays.fill(dp[1], 1);
        for(int i = 2; i<= n; i++) {
            for(int j = 0; j < 5; j++) {
                if(j == 0) 
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1] + dp[i - 1][j + 2] + dp[i - 1][j + 4]) % mod;
                else if(j == 1) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                else if(j == 2) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                else if(j == 3) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                else dp[i][j] = (dp[i][j] + dp[i - 1][j - 2] + dp[i - 1][j - 1])% mod;
                // System.out.println(i+" "+dp[i][j]);
            }
        }
        for(long x : dp[n]) sum = (sum + x);
        return (int)(sum % mod);
    }
}