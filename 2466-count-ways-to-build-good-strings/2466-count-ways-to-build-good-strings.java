class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+1];
        int min = Math.min(zero, one);
        int max = Math.max(zero, one);
        
        dp[min] += 1;
        dp[max] += 1;
        long count = min >= low ? dp[min] : 0;
        long mod = (long)(1e9+7);
        
        for(int i = min + 1; i<= high; i++) {
            int rest1 = i - zero;
            int rest2 = i - one;
            
            if(rest1 < 0 && rest2 < 0) break;
            
            dp[i] += rest1 >= 0 ?(long)dp[rest1]%mod : 0;
            dp[i] += rest2 >= 0 ? (long)dp[rest2]%mod : 0;

            if(i >= low)
                count += dp[i];
        }
        return (int)(count%mod);
    }
}