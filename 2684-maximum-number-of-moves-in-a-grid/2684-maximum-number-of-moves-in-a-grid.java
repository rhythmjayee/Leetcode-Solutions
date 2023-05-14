class Solution {
    public int maxMoves(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int moves = 0;
        int[][] v = new int[n][m];
        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i<n; i++) {
            q.add(new int[]{i, 0});
            v[i][0] = 1;
        }
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                
                for(int i = 0; i<3; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if(nx < 0 || ny < 0 || nx == n || ny == m || v[nx][ny] == 1 || g[nx][ny] <= g[x][y]) continue;
                    v[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }
            if(q.size() > 0) moves++;
        }
        return moves;
    }
}