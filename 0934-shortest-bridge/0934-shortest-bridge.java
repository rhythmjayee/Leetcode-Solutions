class Solution {
    private Queue<int[]> bfsQueue;
    
    private void dfs(int[][] grid, int x, int y, int n) {
        grid[x][y] = 2;//processed
        bfsQueue.add(new int[]{x, y});
        for (int[] pair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
            int curX = pair[0], curY = pair[1];
            if (0 <= curX && curX < n && 0 <= curY && curY < n && grid[curX][curY] == 1) {
                dfs(grid, curX, curY, n);
            }
        }
    }
    
    public int shortestBridge(int[][] grid) {    
        int n = grid.length;
        //get the any Land cell & treat it as a island A's cell
        int firstX = -1, firstY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }
        
        //Get all the land cells of Island A connected with each other
        bfsQueue = new LinkedList<>();
        dfs(grid, firstX, firstY, n);
        
        //do the BFS(shortest distance) to reach at land cell which will be of Island B
        //as we have marked Island land cell to 2
        int distance = 0;//BFS iterations done
        while (!bfsQueue.isEmpty()) {
            int sz = bfsQueue.size();
            while(sz-- > 0){//BFS iteration
                int[] pair = bfsQueue.poll();
                int x = pair[0], y = pair[1];
                for (int[] nextPair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = nextPair[0], curY = nextPair[1];
                    if (0 <= curX && curX < n && 0 <= curY && curY < n) {
                        if (grid[curX][curY] == 1) {//reached at land cell of Island B
                            return distance;
                        } else if (grid[curX][curY] == 0) {//flip 0 -> 1
                            bfsQueue.add(nextPair);
                            grid[curX][curY] = 2;
                        }
                    }
                }
            }
            if(bfsQueue.size() > 0) distance++;
        }
        return distance;
    }   
}