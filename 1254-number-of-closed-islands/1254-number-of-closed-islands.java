class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i = 0; i<m; i++)  {
            dfs(grid, 0, i);
            dfs(grid, n - 1, i);
        }
        for(int i = 0; i<n; i++)  {
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] g, int i, int j) {
        if(i < 0 || j < 0 || i == g.length || j == g[0].length || g[i][j] == 1) return;
        g[i][j] = 1;
        for(int k = 0; k<4; k++) {
            int r = dirs[k][0] + i;
            int c = dirs[k][1] + j;
            dfs(g, r, c);
        }
    }
}