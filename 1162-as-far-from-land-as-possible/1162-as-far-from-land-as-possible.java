class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] v = new int[n][m];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int max = 0;
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j, i , j});
                }
            }
        }
        
        if(q.size() == n*m || q.size() == 0) return -1;
        
        while(!q.isEmpty()) {
            int[] rm = q.remove();
            for(int[] d : dirs) {
                int x = rm[0] + d[0];
                int y = rm[1] + d[1];
                
                if(x < 0 || y < 0 || x == n || y == m) continue;
                if(v[x][y] == 1 || grid[x][y] == 1) continue;
                
                int dist = Math.abs(x - rm[2]) + Math.abs(y - rm[3]);
                max = Math.max(dist, max);
                q.add(new int[]{x, y, rm[2], rm[3]});
                v[x][y] = 1;
            }
        }
        return max;
    }
}