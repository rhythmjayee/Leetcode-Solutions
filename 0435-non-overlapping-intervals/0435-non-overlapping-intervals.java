class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int s = intervals[0][0];
        int e = intervals[0][1];
        int n = intervals.length;
        int count = 0;
        for(int i = 1; i<n; i++) {
            if(e > intervals[i][0]) {
                count++;
            } else {
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        return count;
    }
}