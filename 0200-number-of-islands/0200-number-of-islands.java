class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 ||
           i >= grid.length ||
           j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        
        grid[i][j] = '*';
        int len = 0;
        for(int xy[] : dirs) {
            dfs(grid, i + xy[0], j + xy[1]);
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}