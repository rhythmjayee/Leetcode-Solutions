class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean isInValidBound(char[][] board, int i, int j) {
        return (i < 0 ||
                 j < 0 ||
                 i == board.length ||
                 j == board[0].length ||
                 board[i][j] == '0');
    }
    private boolean dfs(char[][] board, int i, int j, int k, String word) {
        if(k == word.length()) return true;
        else if(isInValidBound(board, i, j) || board[i][j] != word.charAt(k)) return false;
        
        char chr = board[i][j];
        board[i][j] = '0';
        for(int[] x : dirs) {
            if(dfs(board, i + x[0], j + x[1], k + 1, word)) return true;
        }
        board[i][j] = chr;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean ans = dfs(board, i, j, 0, word);
                if(ans) return true;
            }
        }
        return false;
    }
}