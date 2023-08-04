class Solution {
    private Boolean dp[];
    private Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n];
        set = new HashSet<>();
        for(String st : wordDict) set.add(st);
        return dfs(0, s);
    }
    public boolean dfs(int i, String s) {
        if(i == s.length()) return true;
        else if(dp[i] != null) return dp[i];
        
        for(int j = i; j < s.length(); j++) {
            String ns = s.substring(i, j + 1);
            if(set.contains(ns)) {
                if(dfs(j + 1, s)) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}