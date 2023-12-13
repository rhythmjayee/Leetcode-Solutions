class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] r = new int[n];
        int[] c = new int[m];
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(mat[i][j] == 1) {
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(mat[i][j] == 1 && r[i] == 1 && c[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
/*
r-> 1 1 1
c-> 2 0 1

r-> 1 1 1
c-> 1 1 1

r-> 1 0 0 1
c-> 0 1 
*/