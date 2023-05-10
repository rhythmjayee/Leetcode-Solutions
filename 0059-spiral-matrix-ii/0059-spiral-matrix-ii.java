class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int num = 1;
        int r1 = 0;
        int c1 = 0;
        int r2 = n - 1;
        int c2 = n - 1;
        
        while(r1 <= r2 && c1 <= c2){
            for(int c = c1; c <= c2; c++){
                m[r1][c] = num;
                num++;
            }
            for(int r = r1 + 1; r <= r2; r++){
                m[r][c2] = num;
                num++;
            }
            c2--;
            r1++;
            if(r1 < n && c2 > 0){
                for(int c = c2; c >= c1; c--){
                    m[r2][c] = num;
                    num++;
                }
                for(int r = r2 - 1; r >= r1; r--){
                    m[r][c1] = num;
                    num++;
                }
                r2--;
                c1++;
            }
            
        }
        return m;
    }
}