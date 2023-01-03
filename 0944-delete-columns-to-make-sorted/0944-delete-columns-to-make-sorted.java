class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;
        
        for(int i = 0; i<m; i++) {
            Integer[] f = new Integer[26];
            for(int j = 0; j<n; j++) {
                char c = strs[j].charAt(i);
                f[c - 'a'] = j;
            }
            
            int prev = -1;
            for(int j = 0; j<26; j++) {
                if(f[j] == null) continue;
                if(prev == -1 || prev < f[j]) prev = f[j];
                else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}