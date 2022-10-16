class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> ls = new ArrayList<>();
        long mod = (long)(1e9+7);
        int id = 0;
        for(int i = 0; i<32; i++){
            if((n & (1 << i)) != 0)
                ls.add((1 << i));
        }
        // long[] p = new long[ls.size()+1];
        // p[0] = 1L;
        // for(int i = 1; i<=ls.size(); i++){
        //     p[i] = (ls.get(i - 1) * p[i - 1]);
        // }
        int[] ans = new int[queries.length];
        for(int i = 0 ; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            long m = 1L;
            for(int j = l; j<=r; j++){
                m = (m * ls.get(j))%mod;
            }
            ans[i] = (int)m;
        }
        return ans;
    }
}