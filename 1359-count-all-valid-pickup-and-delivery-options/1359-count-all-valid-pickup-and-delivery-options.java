class Solution {
    public int countOrders(int n) {
        // long[] dp = new long[501];
        if(n == 1) return 1;
        int mod = (int)(1e9 + 7);
        // dp[1]=1L;
        // dp[2]=6L;
        long n_1 = 6L;
        for (int i=3;i<=n;i++) {
            //choices To Insert Pickup in previous (i-th) combination
            //Eg:- _,P1,_,P2,_,D1,_,D2,_ => 3 * 2 - 1
            /*
            __ P1 __ P2 __ D1 __ D2 __

            If we place (P3 D3) at space 1 : we can have five combinations: 5
            If we place (P3 D3) at space 2 : we can have four combinations: 4
            If we place (P3 D3) at space 3 : we can have three combinations: 3
            If we place (P3 D3) at space 4 : we can have two combinations: 2
            If we place (P3 D3) at space 5 : we can have two combinations: 1

            Total (5+4+3+2+1) = 15 => (5*(5+1)/2).. sum from 1 to n is (n*(n+1)/2);
            */
            int choicesToInsertPickup = 2 * i - 1;
            int permutations = choicesToInsertPickup * (choicesToInsertPickup + 1) / 2;
            // dp[i] = (dp[i-1]*(permutations))%mod;
            long t = (n_1 * permutations) % mod;
            n_1 = t;
        }
        // return (int) dp[n];
        return (int)(n_1);
    }
}