class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] v = new int[n][m];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int steps = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        v[entrance[0]][entrance[1]] = 1;
        
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int[] rm = q.poll();
                for(int[] d : dirs) {
                    int x = rm[0] + d[0];
                    int y = rm[1] + d[1];
                    if(x < 0 || y < 0 || x == n || y == m || v[x][y] == 1 || maze[x][y] == '+')
                        continue;
                    if(x == 0 || y == 0 || x == n - 1 || y == m - 1)
                        return steps + 1;
                    v[x][y] = 1;
                    q.add(new int[]{x, y});
                }
            }
            if(q.size() > 0) steps++;
        }
        return -1;
    }
}