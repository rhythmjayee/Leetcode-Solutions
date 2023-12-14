class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] zr = new int[n];
        int[] zc = new int[m];
        int[][] ans = new int[n][m];
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == 0) {
                    zr[i]--;
                    zc[j]--;
                }else {
                    zr[i]++;
                    zc[j]++;
                }
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                ans[i][j] =  zr[i] + zc[j];
            }
        }
        return ans;
    }
}