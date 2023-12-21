class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        int max = 0;
        int n = points.length;
        int prev = points[0][0];
        for(int i = 1; i<n; i++) {
            max = Math.max(max, points[i][0] - prev);
            prev = points[i][0];
        }
        return max;
    }
}