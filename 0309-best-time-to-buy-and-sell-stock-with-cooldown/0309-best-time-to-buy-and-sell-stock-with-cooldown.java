class Solution {
    public int maxProfit(int[] prices) {
        /**
        [],i,canBuy
        if(i == n) return 0;
        if(canBuy == 1){
            buy = -[i] + ([],i+1,0);
            notBuy = ([],i+1,1);
            return max
        }else if( prevSell == 0){
            sell = [i]+([],i+2,1);
            notSell = ([],i+1,0);
            return max;
        }
        */
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        
        for(int i = n-1; i>=0 ;i--){
            dp[i][1] = Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i+2][1],dp[i+1][0]);
        }
        return dp[0][1];
    }
}