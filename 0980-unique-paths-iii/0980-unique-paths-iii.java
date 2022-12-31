class Solution {
    int totalZeros = 0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int sr = -1;
        int sc = -1;
        int er = -1;
        int ec = -1;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }else if(grid[i][j] == 2){
                    er = i;
                    ec = j;
                }else if(grid[i][j] == 0) totalZeros++;
            }
        }
        
        int paths = get(grid,sr,sc,er,ec,-1);
        return paths;
    }
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int get(int[][] grid, int i ,int j,int er,int ec,int count){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == -1) return 0;
        else if(i == er && j == ec && totalZeros == count) return 1;
        
        int prev = grid[i][j];
        grid[i][j] = -1;
        int c = 0;
        
        for(int k = 0; k<4; k++){
            c += get(grid,i+dir[k][0],j+dir[k][1],er,ec,count+1);
        }
        
        grid[i][j] = prev;
        return c;
    }
}