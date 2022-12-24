class Solution {
    //https://leetcode.com/problems/domino-and-tromino-tiling/discuss/288662/Java-O(N)-dp-solution-with-really-simple-math
    //https://leetcode.com/problems/domino-and-tromino-tiling/discuss/1620809/PythonJAVACC%2B%2B-DP-oror-Image-Visualized-Explanation-oror-100-Faster-oror-O(N)
    public static final int MOD = (int)(1e9+7);
    public int numTilings(int N) {
        if(N == 1) return 1;
        else if(N == 2 ) return 2;
        int mod = 1000000007;
		int[] f = new int[N + 1];
        
        f[1] = 1;
        f[2] = 2;
        f[3] = 5;
        for(int i = 4; i <= N; i++) {
            f[i] = 2 * f[i - 1] % mod + f[i - 3] % mod;
            f[i] %= mod;
        }
        return (int) f[N];
    }
}