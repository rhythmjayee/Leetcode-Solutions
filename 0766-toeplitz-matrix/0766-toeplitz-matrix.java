class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int val = matrix[i][j];
                //compare with top left (r-1, c-1)
                //as we go down, we had already checked others ele in top rows
                //just need to check with top left ele with curr row ele
                if(i > 0 && j > 0 && matrix[i - 1][j - 1] != val) return false;
            }
        }
        
        return true;
    }
}