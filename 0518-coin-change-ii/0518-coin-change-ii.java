class Solution {
    public void printArr(int[] arr) {
        System.out.print("[ ");
        for(int x : arr) System.out.print(x+" ");
        System.out.println("]");
    }
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int coin = 0; coin < coins.length; coin++) {
            // System.out.println("Indx: "+coins[coin]+" ");
            // printArr(dp);
            //Using coins till coins[coint] -> get combination
            for(int amt = 1; amt <= amount; amt++) {
                if(coins[coin] <= amt) {
                    // System.out.println("Coins used: "+coins[coin]+" Amt: "+amt);
                    dp[amt] += dp[amt - coins[coin]];
                }
            }
            // printArr(dp);
        }
        return dp[amount];
    }
}