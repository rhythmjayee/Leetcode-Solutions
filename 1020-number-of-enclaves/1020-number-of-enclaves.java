class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int dfs(int[][] g, int i, int j) {
        if(i < 0 || j < 0 || i == g.length || j == g[0].length || g[i][j] == 0) return 0;
        g[i][j] = 0;
        int area = 1;
        for(int k = 0; k<4; k++) {
            int r = dirs[k][0] + i;
            int c = dirs[k][1] + j;
            area += dfs(g, r, c);
        }
        return area;
    }
    public int numEnclaves(int[][] grid) {
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
        
        int totalCells = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == 1) {
                    totalCells += dfs(grid, i, j);
                }
            }
        }
        return totalCells;
    }
}