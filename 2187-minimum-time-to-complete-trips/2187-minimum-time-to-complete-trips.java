class Solution {
    private boolean canDo(int[] time, long trips, long minTime) {
        long t = 0;
        for(int x : time) {
            t += minTime / (long)x;
        }
        return t >= trips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long i = 0;
        long j = (long)1e14;
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