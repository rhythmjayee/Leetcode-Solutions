class Solution {
    public int getLengthOfOptimalCompression(String s, int K) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion.
        int n = s.length();
        int[][] dp = new int[n + 1][K + 1];
        for (int[] i : dp) Arrays.fill(i, n);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            //string till ith
            for (int k = 0; k <= K; k++) {
                //atmost k chars can be deleted
                if (k > 0) dp[i][k] = Math.min(dp[i][k], dp[i - 1][k - 1]); // delete s[i] -> string will same as prev
                // keep s[i], concat the same, remove the different
                int same = 0, diff = 0;
                for (int j = i; j >= 1; j--) {
                    if (s.charAt(j - 1) == s.charAt(i - 1)) same++; 
                    else diff++;
                    //we can delete diff char till k as k deletions allowed
                    if (diff > k) break;
                    //delete s[j] char, ans till jth char will be dp[j - 1][k - diff] + len of string after jth char in compressed string
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - diff] + getLen(same));
                }
            }
        }
        return dp[n][K];
    }

    private int getLen(int count) {
        //for count = 1 -> single char can be added to compressed string
        if (count == 1) return 1;
        //for count < 10 -> char + single digit will be added
        else if (count < 10) return 2;
        //for count < 100 -> char + double digit will be added
        else if (count < 100) return 3; 
        else return 4;
    }
}
