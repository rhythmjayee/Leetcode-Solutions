class Solution {
    public int[] findBall(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int[] ans = new int[m];
        
        for(int i = 0; i < m; i++) {
            int row = 0;
            int col = i;
            while(row >= 0 && col >= 0 && row < n && col < m) {
                int val = g[row][col];

                if(val == 1 && (col+1 == m || g[row][col+1] == -1)) {
                    ans[i] = -1;
                    break;
                }else if(val == -1 && (col-1 < 0 || g[row][col-1] == 1)) {
                    ans[i] = -1;
                    break;
                }else if(val == 1) {
                    row++;
                    col++;
                }else if(val == -1) {
                    row++;
                    col--;
                }
                
                if(row == n) {
                    ans[i] = col;
                }
            }
        }
        return ans;
    }
}
/*
if [i,j] = 1
    [i, j+1] = 1 -> ball can pass -> [i+1, j+1]
    [i, j+1] = -1 -> ball stops

if [i, j] = -1
    [i, j-1] = -1 -> ball can pass -> [i+1, j-1]
    [i, j-1] = 1 -> ball stops
*/