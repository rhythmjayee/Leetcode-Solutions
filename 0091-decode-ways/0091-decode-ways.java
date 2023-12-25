class Solution {
    Integer[] dp;
    public int top(int i, String s) {
        if(i == s.length()) return 1;
        else if(dp[i] != null) return dp[i];
        
        int ans = 0;
        if(s.charAt(i) != '0') {
            ans = top(i + 1, s);
        }
        if(i + 1 < s.length()) {
            int val = Integer.valueOf(s.substring(i, i + 2));
            ans += (val > 26 || val < 10) ? 0 : top(i + 2, s);
        }
        dp[i] = ans;
        return ans;
    }
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return top(0, s);
    }
}