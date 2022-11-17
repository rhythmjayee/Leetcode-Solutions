class Solution {
   public boolean isValidSudoku(char[][] board) {
       return isValid(board);
}
    static boolean isValidSubgrid(char[][] mat, int a, int b) {
        int[] freq = new int[10];
        
        for (int i = a; i < a + 3; i++)
            for (int j = b; j < b + 3; j++)
                if(mat[i][j]!='.')
                    if(++freq[mat[i][j]-'0'] > 1)
                        return false;
        
        return true;
    }
    
    static boolean isValidRow(char[][] mat, int rowIndex) {
        
        int[] freq = new int[10];
        for (int i = 0; i < 9; i++)
            if(mat[rowIndex][i]!='.')
                if(++freq[mat[rowIndex][i]-'0'] > 1) 
                    return false;
        
        return true;
    }
    
    static boolean isValidColumn(char[][] mat, int columnIndex) {
        
        int[] freq = new int[10];
        for (int i = 0; i < 9; i++)
            if(mat[i][columnIndex]!='.')
                if(++freq[mat[i][columnIndex]-'0'] > 1) 
                    return false;

        return true;
    }
    
    static boolean isValid(char mat[][]) {
        
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(mat, i) || !isValidColumn(mat, i)) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if(!isValidSubgrid(mat, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}