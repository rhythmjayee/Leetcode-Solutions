class Solution {
    public int minDistance(String word1, String word2) {
        /*
        insert - i, j -> 'x'i, j -> i+1 , j+1
        delete -> i+1, j
        replace -> i+1 , j+1
        */
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= m; i++) {
            dp[0][i] = i;//insert in w1 for zero chars 
        }
        for(int i = 1; i <= n; i++) {
            dp[i][0] = i;//delete in w1 for zero chars in w2
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[n][m];
    }
}