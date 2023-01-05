class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int n = points.length;
        int count = 0;
        int end = points[0][1];
        
        for(int i = 1; i<n; i++) {
            if(end < points[i][0]) {
                end = points[i][1];
               count++;
            }
        }
        count++;
        return count;
    }
}