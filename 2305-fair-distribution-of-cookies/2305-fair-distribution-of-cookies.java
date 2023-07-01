class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] ks = new int[k];
        return dfs(cookies, 0, ks);
    }
    public int dfs(int[] c, int i, int[] ks) {
        if(i == c.length) {
            int max = 0;
            for(int x : ks) max = Math.max(max, x);
            return max;
        }
        int min = Integer.MAX_VALUE;
        for(int k = 0; k<ks.length; k++) {
            ks[k] += c[i];
            min = Math.min(min, dfs(c, i + 1, ks));
            ks[k] -= c[i];
        }
        return min;
    }
}