class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int nn = grid.length;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
       
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0] == 1) return -1;
        q.add(new int[]{0,0});
        
        int steps = 1;
        
        while(!q.isEmpty()){
            int n = q.size();
           
            while(n-- > 0){
                 int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                
                if(x == nn-1 && y == nn-1) return steps;
                
                for(int i = 0; i < 8; i++){
                    int xx = x+dirs[i][0];
                    int yy = y+dirs[i][1];
                    
                    if(xx < 0 || yy < 0 || xx >= nn || yy >= nn || grid[xx][yy] == 1 )
                        continue;
                    q.add(new int[]{xx,yy});
                    grid[xx][yy] = 1;
                }
            }
            if(q.isEmpty()) break;
            else  steps++;
        }
        
        return -1;
    }
}