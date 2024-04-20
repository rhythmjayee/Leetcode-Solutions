class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[] dfs(int[][] grid, int i, int j) {
        if(i < 0 ||
           i >= grid.length ||
           j < 0 || j >= grid[0].length || grid[i][j] != 1) return new int[]{-1, -1};
        
        grid[i][j] = -1;
        int[] ans = {i, j};
        for(int xy[] : dirs) {
            int[] res = dfs(grid, i + xy[0], j + xy[1]);
            if(res[1] > ans[1]) ans = res;
            else if(res[1] >= ans[1] && res[0] > ans[0]) ans = res;
        }
        return ans;
    }
    public int[][] findFarmland(int[][] land) {
        List<int[]> ls = new ArrayList<>();
        int n = land.length;
        int m = land[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1) {
                    int[] ans = dfs(land, i, j);
                    ls.add(new int[]{i, j, ans[0], ans[1]});
                }
            }
        }
        return ls.stream().toArray(int[][]::new);
    }
}