class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if(n != m) return false;
        else if(s1.equals(s2)) return true;
        
        boolean[][][] dp = new boolean[n][n][n+1];//s1,s2,len

         for(int len = 1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                for(int j=0;j<=n-len;j++){
                    if(len == 1){
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                    }else{
                        for(int k=1;k<len && !dp[i][j][len];k++){
                            //divide s1,s2 at k and take till 0 to k
                            //and k to n
                            //or take 0 to k from s1 and k to n in s2 and vice-versa
                            dp[i][j][len] = (dp[i][j][k] && dp[i+k][j+k][len-k]) || (dp[i][j+len-k][k] && dp[i+k][j][len-k]);

                        }
                    }
                }
            }
         }
       return dp[0][0][n];
        
    }
}