class Solution {
    //zero_count that represents the number of children without a cookie
    public int distributeCookies(int[] cookies, int k) {
        int[] ks = new int[k];
        return dfs(cookies, 0, ks, k);
    }
    public int dfs(int[] c, int i, int[] ks, int zero_count) {
        if(c.length - i < zero_count) return Integer.MAX_VALUE;
        if(i == c.length) {
            int max = 0;
            for(int x : ks) max = Math.max(max, x);
            return max;
        }
        int min = Integer.MAX_VALUE;
        for(int k = 0; k<ks.length; k++) {
            zero_count -= ks[k] == 0 ? 1 : 0;
            ks[k] += c[i];
            min = Math.min(min, dfs(c, i + 1, ks, zero_count));
            ks[k] -= c[i];
            zero_count += ks[k] == 0 ? 1 : 0;
        }
        return min;
    }
}