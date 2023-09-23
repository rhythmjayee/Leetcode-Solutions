class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        
        Arrays.sort(words,(s1,s2)->s1.length()-s2.length());
        Arrays.fill(dp,1);
        
        int max = 1;
        
        for(int i = 0; i<n; i++){
            String wrd1 = words[i];
            for(int j = i+1; j<n; j++){
                String wrd2 = words[j];
                if(wrd2.length() > wrd1.length()+1) break;
                else if(wrd2.length() <= wrd1.length()) continue;
                
                boolean lcs = isPredecessor(wrd1,wrd2);
                if(lcs){
                    dp[j] = Math.max(dp[j],dp[i] + 1);
                    max = Math.max(max,dp[j]);
                }
            }
        }
        return max;
    }
    private boolean isPredecessor(String s1, String s2) {
        if (s2.length() == s1.length()) return false;
        int diff = 0;
        for (int i = 0, j = 0; i < s1.length(); ) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (diff > 1) return false;
                j++;
            }
        }
        return true;
    }
}