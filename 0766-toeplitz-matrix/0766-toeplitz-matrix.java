class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int val = matrix[i][j];
                map.putIfAbsent(i - j, val);
                if(map.get(i - j) != val) return false;
            }
        }
        
        return true;
    }
}