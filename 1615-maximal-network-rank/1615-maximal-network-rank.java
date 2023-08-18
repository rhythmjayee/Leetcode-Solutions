class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegree = new int[n];
        int[][] conn = new int[n][n];
        int max = 0;
        for(int x[] : roads) {
            inDegree[x[0]]++;
            inDegree[x[1]]++;
            conn[x[0]][x[1]] = 1;
            conn[x[1]][x[0]] = 1;
        }
        for(int i = 0; i< n; i++) {
            for(int j = i + 1; j < n; j++) {
                int network = inDegree[i] + inDegree[j];
                if(conn[i][j] == 1) network--;
                max = Math.max(max, network);
            }
        }
        return max;
    }
}