class Solution {
    Integer[][] dp;
    public int tallestBillboard(int[] rods) {
        this.dp = new Integer[rods.length][10001];
        return fun(0 , rods , 0)/2;
    }
    
    int fun(int i , int[] arr , int diff){
        if(i == arr.length){
            if(diff == 0) return 0;
            else return -0x3fffffff;
        }
        else if(dp[i][diff+5000] != null) return dp[i][diff+5000];
        
        
        int a = fun(i+1 , arr , diff);
        
        int b = arr[i] + fun(i+1 , arr , diff + arr[i]);
        
        int c = arr[i] + fun(i+1 , arr , diff - arr[i]);
        
        return dp[i][diff+5000] = Math.max(a , Math.max(b , c));
    }
}