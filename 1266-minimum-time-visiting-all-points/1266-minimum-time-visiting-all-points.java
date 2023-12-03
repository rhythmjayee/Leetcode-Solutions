class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        int px = points[0][0];
        int py = points[0][1];
        int n = points.length;
        for(int i = 1; i<n; i++) {
            int cx = points[i][0];
            int cy = points[i][1];
            int ax = Math.abs(cx - px);
            int ay = Math.abs(cy - py);
            count += Math.max(ax, ay);
            px = cx;
            py = cy;
        }
        return count;
    }
}