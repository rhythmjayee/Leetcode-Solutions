class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] checkPal = isPal(s);
        List<List<String>> ans = new ArrayList<>();
        
        get(s,0,ans,new ArrayList<>(),checkPal);
        
        return ans;
    }
    public void get(String s, int i, List<List<String>> ans, List<String> ls,boolean[][] checkPal){
        if(i == s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }
        
        for(int k = i; k<s.length(); k++){
            if(checkPal[i][k]){
                ls.add(s.substring(i,k+1));
                get(s,k+1,ans,ls,checkPal);
                ls.remove(ls.size()-1);
            }
        }
    }
    public boolean[][] isPal(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        int n = s.length();
        for(int gap = 0; gap<n; gap++){
            for(int i = 0, j = gap; j<n; j++,i++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        
        return dp;
    }
}