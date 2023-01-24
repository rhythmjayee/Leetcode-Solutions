class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int f = 0;
        int []moves = new int[n*n+1];
        int id = 1;
        for(int i=n-1;i>=0;i--){
            if(f == 0){
               for(int j=0;j<n;j++){
                     moves[id++] = board[i][j];
                } 
                f = 1;
            }else{
                for(int j=n-1;j>=0;j--){
                     moves[id++] = board[i][j];
                } 
                f = 0;
            }
            
        }
        return getMinDiceThrows(moves,n*n+1);
    }

    static int getMinDiceThrows(int move[], int n) 
    {
        int visited[] = new int[n];
        Queue<int[]> q = new LinkedList<>();
        //number, distance
        q.add(new int[]{1, 0});
        visited[1] = 1;
  
        while (!q.isEmpty()) 
        {
            int[] rm = q.remove();
            int v = rm[0];
            //at last cell of board
            if (v == n - 1) return rm[1];
            //we have max 6 on dices inorder to move from curr number
            for (int j = v + 1; j <= (v + 6) && j < n; ++j) 
            {
                if (visited[j] == 0)
                {
                    int vv = j;
                    visited[j] = 1;
                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (move[j] != -1)
                        vv = move[j];
                    
                   q.add(new int[]{vv, rm[1] + 1});
                }
            }
        }
        return -1;
    }
}