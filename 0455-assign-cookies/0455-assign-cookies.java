class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = n - 1;//index on greed
        int j = m - 1;//index on cookie
        while(i >= 0 && j >= 0) {
            if(s[j] >= g[i]) {
                count++;
                i--;
                j--;
            } else if(g[i] > s[j]) {
                i--;
            }
        }
        return count;
    }
}