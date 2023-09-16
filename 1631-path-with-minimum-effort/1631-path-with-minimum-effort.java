class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        int n = heights.length;
        int m = heights[0].length;
        //consider each cell as node
        //this will store min possible effort path ans
        int[][] minEffort = new int[n][m];
        
        for(int i = 0; i<n; i++) Arrays.fill(minEffort[i],Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{//row,col,path effort
            return a[2]-b[2];
        });
        pq.add(new int[]{0,0,0});
        minEffort[0][0] = 0;
        
        while(!pq.isEmpty()){
            int[] rm = pq.remove();
            int i = rm[0];
            int j = rm[1];
            int eff = rm[2];
            
            if(minEffort[i][j] < eff) continue;
            if(i == n-1 && j == m-1) return eff;//path with min effort will get first
            
            
            for(int k = 0; k<4; k++){
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                
                if(x < 0 || y < 0 || x == n || y == m ) continue;
                
                int maxEffortOfPath = Math.max(eff,Math.abs(heights[x][y] - heights[i][j]));
                
                if(minEffort[x][y] > maxEffortOfPath){
                    minEffort[x][y] = maxEffortOfPath;
                     pq.add(new int[]{x,y,maxEffortOfPath});
                }
               
            }
            
        }
        return -1;
    }
}