class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> q = new LinkedList<>();//i,j,k,steps
        //i, j, k, steps
        q.add(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        
        while(!q.isEmpty()){
            int[] rm = q.poll();
            int x = rm[0];
            int y = rm[1];
            int ck = rm[2];
            int steps = rm[3];

            if(x == m-1 && y == n-1) return steps;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                int nk = ck;
            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                
                if(grid[nx][ny] == 1){
                   nk++;
                }
                
                if(nk <= k && !visited[nx][ny][nk]){
                    q.add(new int[]{nx,ny,nk,steps+1});
                    visited[nx][ny][nk] = true;
                }
            }
        }
        return -1;
    }
}