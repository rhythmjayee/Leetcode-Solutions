class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length() + 1][s2.length() + 1];
        return top(0, 0, s1, s2);
    }
    public int top(int i, int j, String s1, String s2) {
        if(i == s1.length() || j == s2.length()) {
            int c1 = 0;
            int c2 = 0;
            while(i < s1.length()) {
                c1 += s1.charAt(i++);
            }
            while(j < s2.length()) {
                c2 += s2.charAt(j++);
            }
            return c1 + c2;
        }else if(dp[i][j] != null) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if(s1.charAt(i) == s2.charAt(j)) {
            ans = top(i + 1, j + 1, s1, s2);
        } else {
            int deleteFromS1 = top(i + 1, j, s1, s2) + s1.charAt(i);
            int deleteFromS2 = top(i, j + 1, s1, s2) + s2.charAt(j);
            ans = Math.min(deleteFromS1, deleteFromS2);
        }
        dp[i][j] = ans;
        return ans;
    }
}