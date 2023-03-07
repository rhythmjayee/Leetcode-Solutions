class Solution {
    private boolean canDo(int[] time, long trips, long minTime) {
        long t = 0;
        for(int x : time) {
            t += minTime / (long)x;
        }
        return t >= trips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int max_time = 0;
        for (int t : time) {
            max_time = Math.max(max_time, t);
        }
        long i = 1;
        long j = (long) max_time * totalTrips;
        while(i < j) {
            long timeNeeded = i + ((j - i) >> 1);
            if(canDo(time, totalTrips, timeNeeded)) {
                j = timeNeeded;
            }else {
                i = timeNeeded + 1;
            }
        }
        return j;
    }
}