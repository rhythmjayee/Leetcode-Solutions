class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        s1, s2, s3, i, j, k
        if i == len(s1) && j == len(s2) return true
        */
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length()][s2.length()];
        return dfs(s1, s2, s3, 0, 0, 0);
    }
    public Boolean dp[][];
    public boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if(i == s1.length() && j == s2.length()) return true;
        else if(i == s1.length()) {
            while(j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
                j++;
                k++;
            }
            return j == s2.length() && k == s3.length();
        } else if(j == s2.length()) {
            while(i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
                i++;
                k++;
            }
            return i == s1.length() && k == s3.length();
        } else if(dp[i][j] != null) return dp[i][j];
        
        boolean ans = false;
        // System.out.println(s3.charAt(k)+"==>");
        if(s1.charAt(i) == s3.charAt(k)) {
            ans |=  dfs(s1, s2, s3, i + 1, j, k + 1);
            // System.out.println(s1.charAt(i)+" "+i +" -->");
        }
        if(s2.charAt(j) == s3.charAt(k)) {
            ans |=  dfs(s1, s2, s3, i, j + 1, k + 1);
            // System.out.println(s2.charAt(j)+" "+j +" -->");
        }
        return dp[i][j] = ans;
    }
}