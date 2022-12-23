class Solution {
    public int maxProfit(int[] p) {
        return td(p, 1, 0, new Integer[p.length][2]);
    }
    private int td(int[] p, int buy, int i, Integer[][] dp) {
        if(i >= p.length) return 0;
        else if(dp[i][buy] != null) return dp[i][buy];
        
        int b = Integer.MIN_VALUE;
        int s = Integer.MIN_VALUE;
        int nb = Integer.MIN_VALUE;
        int ns = Integer.MIN_VALUE;
        
        if(buy == 1) {
            b = -p[i] + td(p, 0, i + 1, dp);
            nb = td(p, 1, i + 1, dp);
        }else if(buy == 0) {
            s = p[i] + td(p, 1, i + 2, dp);
            ns = td(p, 0, i + 1, dp);
        }
        
        dp[i][buy] = Math.max(Math.max(b, nb), Math.max(s, ns));
        return dp[i][buy];
    }
}