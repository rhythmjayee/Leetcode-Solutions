class Solution {
    Integer[][]dp;
    public int minInsertions(String s) {
        dp = new Integer[s.length()][s.length()];
        return top(s, 0, s.length() - 1);
    }
    public int top(String s, int i, int j){
        if(i == j) return 0;
        else if(i == j + 1 && s.charAt(i) == s.charAt(j)) return 0;
        else if(dp[i][j] != null) return dp[i][j];
        int same = Integer.MAX_VALUE;
        int addIth = Integer.MAX_VALUE;
        int addJth = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        if(s.charAt(i) == s.charAt(j)) {
            same = top(s, i + 1, j - 1);
        }else {
            addIth = top(s, i, j - 1);
            addJth = top(s, i + 1, j);
            min = Math.min(addIth, addJth);
            if(min != Integer.MAX_VALUE) min += 1;
        }
        return dp[i][j] = Math.min(same, min);
    }
}