class Solution {
    Integer[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        dp = new Integer[s.length()];
        Set<String> set = new HashSet<>();
        for(String sr : dictionary) set.add(sr);
        
        return dfs(0, s, set);
    }
    public int dfs(int i, String s, Set<String> set) {
        if(i == s.length()) return 0;
        else if(dp[i] != null) return dp[i];
        
        int min = dfs(i + 1, s, set) + 1;//leftover character
        for(int k = i + 1; k <= s.length(); k++) {
            String sub = s.substring(i, k);
            int res = dfs(k, s, set);
            if(set.contains(sub)) {
                min = Math.min(min, res);
            }
        }
        return dp[i] = min;
    }
}