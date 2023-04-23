class Solution {
    int mod = (int)(1e9+7);
    Integer[] dp;
    public int numberOfArrays(String s, int k) {
        dp = new Integer[s.length()];
        return top(s, 0, k);
    }
    public int top(String s, int i, int k) {
        if(i == s.length()) return 1;
        else if(s.charAt(i) == '0') return 0;
        else if(dp[i] != null) return dp[i];
        
        int total = 0;
        for(int j = i; j<s.length(); j++) {
            String sub = s.substring(i,j+1);
            long num = Long.valueOf(sub);
            if(num <= k) {
                total = (total + top(s, j + 1, k)) % mod;
            }else break;
        }
        return dp[i] = total;
    }
}