class Solution {
    public int minSpeedOnTime(int[] dist, double hours) {
        int ans = -1;
        int i = 1;
        int j = (int)(1e7);
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            double totalTimeNeeded = TryTravelInTime(dist, md);
            if(totalTimeNeeded <= hours) {
                ans = md;
                j = md - 1;
            } else {
                i = md + 1;
            }
        }
        return ans;
    }
    public double TryTravelInTime(int[] dist, int speed) {
        double time = 0.0;
        for(int i = 0; i < dist.length; i++) {
            double timeTookByIth = dist[i] / (double)speed;
            double timeTillNow = time + timeTookByIth;
            // System.out.println(timeTillNow+" "+speed );
            if(dist.length - 1 == i) {
                return timeTillNow;
            }
            time += Math.ceil(timeTookByIth);
            
        }
        return 0.0;
    }
}